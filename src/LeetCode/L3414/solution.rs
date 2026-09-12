use super::Solution;

/*
    给你一个二维整数数组 intervals，其中 intervals[i] = [li, ri, weighti]。区间 i 的起点为 li，终点为 ri，权重为 weighti。你最多可以选择 4 个互不重叠 的区间。所选择区间的 得分 定义为这些区间权重的总和。

    返回一个至多包含 4 个下标且 字典序最小 的数组，表示从 intervals 中选中的互不重叠且得分最大的区间。

    如果两个区间没有任何重叠点，则称二者 互不重叠 。特别地，如果两个区间共享左边界或右边界，也认为二者重叠。

    提示：

    1 <= intervals.length <= 5 * 10^4
    intervals[i].length == 3
    intervals[i] = [li, ri, weighti]
    1 <= li <= ri <= 10^9
    1 <= weighti <= 10^9
*/

impl Solution {
    pub fn maximum_weight(intervals: Vec<Vec<i32>>) -> Vec<i32> {
        let n = intervals.len();
        let mut sorted_idx: Vec<usize> = (0..n).collect();
        sorted_idx.sort_by_key(|k| intervals[*k][1]);

        let mut dp: Vec<Vec<(i64, Vec<i32>)>> = vec![vec![(0i64, Vec::new()); 5]; n + 1];
        for (i, idx) in sorted_idx.iter().enumerate() {
            let (l, r, weight) = (intervals[*idx][0], intervals[*idx][1], intervals[*idx][2]);
            let k = sorted_idx[..i].partition_point(|x| intervals[*x][1] < l);

            for j in 1..5 {
                let s1 = dp[i][j].0;
                let s2 = dp[k][j - 1].0 + weight as i64;

                // Whether use intervals[i[ for dp[i+1][j]
                if s1 > s2 {
                    dp[i + 1][j] = dp[i][j].clone();
                    continue;
                }

                let mut new_idx = dp[k][j - 1].1.clone();
                new_idx.push(*idx as i32);
                new_idx.sort();

                if s1 == s2 {
                    let mut use_new_idx = true;
                    let mut switch_len = true;
                    let min_len = new_idx.len().min(dp[i][j].1.len());
                    for ii in 0..min_len {
                        if new_idx[ii] > dp[i][j].1[ii] {
                            use_new_idx = false;
                            break;
                        } else if new_idx[ii] < dp[i][j].1[ii] {
                            switch_len = false;
                            break;
                        }
                    }
                    if use_new_idx && switch_len && new_idx.len() > dp[i][j].1.len() {
                        use_new_idx = false;
                    }

                    if !use_new_idx {
                        new_idx = dp[i][j].1.clone();
                    }
                }
                dp[i + 1][j] = (s2, new_idx)
            }
        }

        dp[n][4].1.clone()
    }
}

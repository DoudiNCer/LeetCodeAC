use super::Solution;

/*
    给你一个整数 n，表示图中的节点数量，这些节点按从 0 到 n - 1 编号。

    同时给你一个长度为 n 的整数数组 nums，以及一个整数 maxDiff。

    如果满足 |nums[i] - nums[j]| <= maxDiff（即 nums[i] 和 nums[j] 的 绝对差 至多为 maxDiff），则节点 i 和节点 j 之间存在一条 无向边 。

    此外，给你一个二维整数数组 queries。对于每个 queries[i] = [ui, vi]，找到节点 ui 和节点 vi 之间的 最短距离 。如果两节点之间不存在路径，则返回 -1。

    返回一个数组 answer，其中 answer[i] 是第 i 个查询的结果。

    注意：节点之间的边是无权重（unweighted）的。

    提示：

    1 <= n == nums.length <= 105
    0 <= nums[i] <= 105
    0 <= maxDiff <= 105
    1 <= queries.length <= 105
    queries[i] == [ui, vi]
    0 <= ui, vi < n
*/

impl Solution {
    pub fn path_existence_queries(
        n: i32,
        nums: Vec<i32>,
        max_diff: i32,
        queries: Vec<Vec<i32>>,
    ) -> Vec<i32> {
        let n = n as usize;
        // sort node by num
        let mut sorted_idx: Vec<usize> = (0..n).collect();
        sorted_idx.sort_by_key(|a| nums[*a]);
        let mut sorted_pos = vec![0; n];
        for (i, id) in sorted_idx.iter().enumerate() {
            sorted_pos[*id] = i;
        }

        // generate binary lifting
        let m = (n as f64).log2().ceil() as usize + 1;
        let mut bl = vec![vec![0; m]; n];
        let mut l = 0usize;
        for r in 0..n {
            while l < r && nums[sorted_idx[l]] + max_diff < nums[sorted_idx[r]] {
                l += 1;
            }
            bl[r][0] = l;
        }

        for j in 1..m {
            for i in 0..n {
                bl[i][j] = bl[bl[i][j - 1]][j - 1];
            }
        }

        let mut res = Vec::with_capacity(queries.len());
        for query in queries {
            let (mut ql, mut qr) = (sorted_pos[query[0] as usize], sorted_pos[query[1] as usize]);
            if ql == qr {
                res.push(0);
                continue;
            }
            if bl[ql][m - 1] != bl[qr][m - 1] {
                res.push(-1);
                continue;
            }
            if ql > qr {
                (ql, qr) = (qr, ql);
            }
            let mut step = 0;
            for j in (0..m).rev() {
                if bl[qr][j] > ql {
                    qr = bl[qr][j];
                    step += 1 << j;
                }
            }

            res.push(step + 1);
        }
        res
    }
}

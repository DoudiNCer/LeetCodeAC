use super::Solution;

/*
    二指输入法定制键盘在 X-Y 平面上的布局如上图所示，其中每个大写英文字母都位于某个坐标处。

    例如字母 A 位于坐标 (0,0)，字母 B 位于坐标 (0,1)，字母 P 位于坐标 (2,3) 且字母 Z 位于坐标 (4,1)。
    给你一个待输入字符串 word，请你计算并返回在仅使用两根手指的情况下，键入该字符串需要的最小移动总距离。

    坐标 (x1,y1) 和 (x2,y2) 之间的 距离 是 |x1 - x2| + |y1 - y2|。

    注意，两根手指的起始位置是零代价的，不计入移动总距离。你的两根手指的起始位置也不必从首字母或者前两个字母开始。

    提示：

    2 <= word.length <= 300
    每个 word[i] 都是一个大写英文字母。
*/

impl Solution {
    fn get_distance(p: i32, q: i32) -> i32 {
        let x1 = p / 6;
        let y1 = p % 6;
        let x2 = q / 6;
        let y2 = q % 6;
        (x1 - x2).abs() + (y1 - y2).abs()
    }

    pub fn minimum_distance(word: String) -> i32 {
        let n = word.len();
        let word_bytes = word.as_bytes();
        let mut dp = vec![vec![i32::MAX >> 1; 26]; n];

        for j in 0..26 {
            dp[0][j] = 0;
        }

        for i in 1..n {
            let cur = (word_bytes[i] - b'A') as i32;
            let prev = (word_bytes[i - 1] - b'A') as i32;
            let d = Self::get_distance(prev, cur);

            for j in 0..26 {
                dp[i][j] = dp[i][j].min(dp[i - 1][j].saturating_add(d));

                if prev == j as i32 {
                    for k in 0..26 {
                        let d0 = Self::get_distance(k as i32, cur);
                        dp[i][j] = dp[i][j].min(dp[i - 1][k].saturating_add(d0));
                    }
                }
            }
        }

        let mut ans = i32::MAX >> 1;
        for j in 0..26 {
            ans = ans.min(dp[n - 1][j]);
        }
        ans
    }
}
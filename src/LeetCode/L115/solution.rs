use super::Solution;

/*
    给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。

    测试用例保证结果在 32 位有符号整数范围内。

    提示：

    1 <= s.length, t.length <= 1000
    s 和 t 由英文字母组成
*/

impl Solution {
    pub fn num_distinct(s: String, t: String) -> i32 {
        let s = s.into_bytes();
        let t = t.into_bytes();
        let sn = s.len();
        let tn = t.len();
        let mut dp = vec![vec![0; tn + 1]; sn + 1];
        for j in 0..tn {
            for i in 0..sn {
                dp[i + 1][j + 1] = dp[i][j + 1]; // Add an unused char
                if s[i] == t[j] {
                    dp[i][0] = 1;
                    // use the current char
                    dp[i + 1][j + 1] += dp[i][j]
                }
            }
        }
        dp[sn][tn]
    }
}

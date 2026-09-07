use super::Solution;

/*
    给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。

    字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。

    例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。

    提示：

    1 <= s.length <= 2000
    s 仅由小写英文字母组成
*/

const MOD: i64 = 1_000_000_007;

impl Solution {
    pub fn distinct_subseq_ii(s: String) -> i32 {
        let mut dp = vec![0i64; 26];
        let mut sum = 0;
        for x in s.as_bytes() {
            let idx = *x as usize - b'a' as usize;
            (dp[idx], sum) = ((sum + 1) % MOD, (sum + (sum + 1) % MOD - dp[idx]) % MOD)
        }
        ((sum + MOD) % MOD) as i32
    }
}

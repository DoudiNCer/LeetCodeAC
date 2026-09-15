use super::Solution;

/*
    给你一个字符串 s 和一个 正 整数 k 。

    从字符串 s 中选出一组满足下述条件且 不重叠 的子字符串：

    每个子字符串的长度 至少 为 k 。
    每个子字符串是一个 回文串 。
    返回最优方案中能选择的子字符串的 最大 数目。

    子字符串 是字符串中一个连续的字符序列。

    提示：

    1 <= k <= s.length <= 2000
    s 仅由小写英文字母组成
*/

impl Solution {
    pub fn max_palindromes(s: String, k: i32) -> i32 {
        let bits = s.into_bytes();
        let n = bits.len();
        // prepare to find all palindrome
        let mut is_palindrome: Vec<Vec<bool>> = Vec::with_capacity(n);
        for i in 0..n {
            let mut is_l = vec![false; i + 1];
            is_l[i] = true;
            is_palindrome.push(is_l);
        }
        for len in 2..=n {
            for i in 0..n + 1 - len {
                let j = i + len - 1;
                if bits[i] == bits[j] {
                    if len == 2 || is_palindrome[j - 1][i + 1] {
                        is_palindrome[j][i] = true;
                    }
                }
            }
        }

        // Dynamic Planning for the length of s
        let mut dp = vec![0; n + 1];
        let k = k as usize;
        for i in (k - 1)..n {
            dp[i + 1] = dp[i];
            for j in 0..=i + 1 - k {
                if is_palindrome[i][j] {
                    dp[i + 1] = dp[i + 1].max(dp[j] + 1)
                }
            }
        }
        dp[n]
    }
}

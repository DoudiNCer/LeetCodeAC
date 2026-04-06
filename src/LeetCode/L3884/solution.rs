use super::Solution;

/*
  给你一个长度为 n 的字符串 s，其中只包含小写英文字母。

  返回最小的下标 i，使得 s[i] == s[n - i - 1]。

  如果不存在这样的下标，返回 -1。

  提示：

  1 <= n == s.length <= 100
  s 仅包含小写英文字母。
*/

impl Solution {
    pub fn first_matching_index(s: String) -> i32 {
        let sb = s.as_bytes();
        let n = sb.len();
        for i in 0..(n / 2 + 1) {
            if sb[i] == sb[n - i - 1] {
                return i as i32
            }
        }
        -1
    }
}
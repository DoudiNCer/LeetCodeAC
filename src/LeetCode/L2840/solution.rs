use std::arch::aarch64::uint8x8_t;
use super::Solution;

/*
  给你两个字符串 s1 和 s2 ，两个字符串长度都为 n ，且只包含 小写 英文字母。

  你可以对两个字符串中的 任意一个 执行以下操作 任意 次：

  选择两个下标 i 和 j ，满足 i < j 且 j - i 是 偶数，然后 交换 这个字符串中两个下标对应的字符。


  如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。

  提示：

  n == s1.length == s2.length
  1 <= n <= 10^5
  s1 和 s2 只包含小写英文字母。
*/

impl Solution {
    pub fn check_strings(s1: String, s2: String) -> bool {
        if s1 == s2 {
            return true;
        }
        let sb1 = s1.as_bytes();
        let sb2 = s2.as_bytes();
        let mut sb1e :Vec<u8> = Vec::new();
        let mut sb1o :Vec<u8> = Vec::new();
        let mut sb2e :Vec<u8> = Vec::new();
        let mut sb2o :Vec<u8> = Vec::new();
        for (i, b) in sb1.iter().enumerate() {
            if i % 2 == 0 {
                sb1e.push(*b)
            } else {
                sb1o.push(*b)
            }
        }
        for (i, b) in sb2.iter().enumerate() {
            if i % 2 == 0 {
                sb2e.push(*b)
            } else {
                sb2o.push(*b)
            }
        }
        sb1o.sort();
        sb1e.sort();
        sb2o.sort();
        sb2e.sort();
        for i in 0..sb1o.len().max(sb2o.len()) {
            if sb1o.get(i) != sb2o.get(i) {
                return false
            }
        }
        for i in 0..sb1e.len().max(sb2e.len()) {
            if sb1e.get(i) != sb2e.get(i) {
                return false
            }
        }
        true
    }
}
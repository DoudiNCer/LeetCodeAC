use super::Solution;

/*
  给你两个字符串 s1 和 s2 ，两个字符串的长度都为 4 ，且只包含 小写 英文字母。

  你可以对两个字符串中的 任意一个 执行以下操作 任意 次：

  选择两个下标 i 和 j 且满足 j - i = 2 ，然后 交换 这个字符串中两个下标对应的字符。
  如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。

  提示：

  s1.length == s2.length == 4
  s1 和 s2 只包含小写英文字母。
*/

impl Solution {
    pub fn can_be_equal(s1: String, s2: String) -> bool {
        if s1 == s2 {
            return true;
        }
        unsafe {
            let mut sb = s2.as_bytes().to_vec();
            sb.swap(0, 2);
            if String::from_utf8(Vec::from(sb)) == Ok(s1.clone()) {
                return true;
            }
        }
        unsafe {
            let mut sb = s2.as_bytes().to_vec();
            sb.swap(1, 3);
            if String::from_utf8(Vec::from(sb.clone())) == Ok(s1.clone()) {
                return true;
            }
            sb.swap(0, 2);
            if String::from_utf8(Vec::from(sb)) == Ok(s1) {
                return true;
            }
        }
        false
    }
}
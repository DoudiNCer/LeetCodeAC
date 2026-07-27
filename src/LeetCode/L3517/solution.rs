use super::Solution;
/*
    给你一个 回文 字符串 s。

    返回 s 的按字典序排列的 最小 回文排列。

    如果一个字符串从前往后和从后往前读都相同，那么这个字符串是一个 回文 字符串。

    排列 是字符串中所有字符的重排。

    如果字符串 a 按字典序小于字符串 b，则表示在第一个不同的位置，a 中的字符比 b 中的对应字符在字母表中更靠前。
    如果在前 min(a.length, b.length) 个字符中没有区别，则较短的字符串按字典序更小。

    提示：

    1 <= s.length <= 10^5
    s 由小写英文字母组成。
    保证 s 是回文字符串。
*/

impl Solution {
    pub fn smallest_palindrome(s: String) -> String {
        let mut sb = s.as_bytes();
        let n = sb.len();
        let mut target = sb[..(n >> 1)].to_vec();
        target.sort();
        let mut rev_tg = target.clone();
        rev_tg.reverse();
        if n & 1 == 1 {
            target.push(sb[n >> 1]);
        }
        target.append(&mut rev_tg);
        String::try_from(target).unwrap()
    }
}

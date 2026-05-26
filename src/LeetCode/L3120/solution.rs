use super::Solution;

/*
    给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。

    返回 word 中 特殊字母 的数量。

    提示：

    1 <= word.length <= 50
    word 仅由小写和大写英文字母组成。
*/

impl Solution {
    pub fn number_of_special_chars(word: String) -> i32 {
        let mut hash = vec![0; 26];
        let byword = word.as_bytes();
        for x in byword {
            if 'Z' < char::from(*x) {
                hash[(*x - 'a' as u8) as usize] |= 1
            } else {
                hash[(*x - 'A' as u8) as usize] |= 1 << 1
            }
        }
        let mut res = 0;
        for x in hash {
            if x == (1 + (1 << 1)) {
                res += 1
            }
        }
        res
    }
}

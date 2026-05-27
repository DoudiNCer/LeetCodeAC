use super::Solution;

/*
    给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。

    返回 word 中 特殊字母 的数量。

    提示：

    1 <= word.length <= 2 * 10^5
    word 仅由小写和大写英文字母组成。
*/

impl Solution {
    pub fn number_of_special_chars(word: String) -> i32 {
        let mut hash = vec![(false, false, true); 26];
        let byword = word.as_bytes();
        for x in byword {
            if 'Z' < char::from(*x) {
                hash[(*x - 'a' as u8) as usize].0 = true;
                if hash[(*x - 'a' as u8) as usize].1 {
                    hash[(*x - 'a' as u8) as usize].2 = false
                }
            } else {
                hash[(*x - 'A' as u8) as usize].1 = true;
            }
        }
        let mut result = 0;
        for (hasSmall, hasBig, locationOk) in hash {
            if hasSmall && hasBig && locationOk {
                result += 1
            }
        }
        result
    }
}

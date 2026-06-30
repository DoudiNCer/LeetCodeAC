use super::Solution;

/*
    给你一个字符串数组 words，其中每个字符串表示一个由小写英文字母组成的单词。

    同时给你一个长度为 26 的整数数组 weights，其中 weights[i] 表示第 i 个小写英文字母的权重。

    单词的 权重 定义为其所有字符权重的 总和。

    对于每个单词，将其权重对 26 取模，并将结果按字母倒序映射到一个小写英文字母（0 -> 'z', 1 -> 'y', ..., 25 -> 'a'）。

    返回一个由所有单词映射后的字符按顺序连接而成的字符串。

    提示：

    1 <= words.length <= 100
    1 <= words[i].length <= 10
    weights.length == 26
    1 <= weights[i] <= 100
    words[i] 仅由小写英文字母组成。
*/

impl Solution {
    pub fn map_word_weights(words: Vec<String>, weights: Vec<i32>) -> String {
        let mut chars: Vec<u8> = Vec::with_capacity(words.len());
        for word in words {
            let mut weight = 0;
            for x in word.as_bytes() {
                weight += weights.get((*x - ('a' as u8)) as usize).unwrap()
            }
            weight %= 26;
            chars.push(('a' as u8) + 25 - weight as u8)
        }
        String::from_utf8(chars).unwrap()
    }
}

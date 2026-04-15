use super::Solution;

/*
    给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。

    提示：

    2 <= words.length <= 1000
    1 <= words[i].length <= 1000
    words[i] 仅包含小写字母
*/

use std::collections::HashMap;
impl Solution {
    pub fn max_product(words: Vec<String>) -> i32 {
        let mut hm:HashMap<u32, i32> = HashMap::new();
        for word in words {
            let wb = word.bytes();
            let len = wb.len() as i32;
            let mut cb = 0u32;
            for x in wb {
                cb |= 1 << (x - b'a')
            }
            hm.entry(cb).and_modify(|v| *v = (*v).max(len)).or_insert(len);
        }
        let mut keys: Vec<u32> = hm.keys().cloned().collect();
        keys.sort_by(|a, b| hm[b].cmp(&hm[a]));
        let mut result = 0;
        for (i, cba) in keys.iter().enumerate() {
            for j in (i + 1)..keys.len() {
                let cbb = keys[j];
                if cba & cbb == 0 {
                    result = result.max(hm[cba] * hm[&cbb]);
                    break
                }
            }
        }
        result
    }
}
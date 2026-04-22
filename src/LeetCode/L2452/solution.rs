use super::Solution;

/*
    给你两个字符串数组 queries 和 dictionary 。数组中所有单词都只包含小写英文字母，且长度都相同。

    一次 编辑 中，你可以从 queries 中选择一个单词，将任意一个字母修改成任何其他字母。从 queries 中找到所有满足以下条件的字符串：不超过 两次编辑内，字符串与 dictionary 中某个字符串相同。

    请你返回 queries 中的单词列表，这些单词距离 dictionary 中的单词 编辑次数 不超过 两次 。单词返回的顺序需要与 queries 中原本顺序相同。

    提示:

    1 <= queries.length, dictionary.length <= 100
    n == queries[i].length == dictionary[j].length
    1 <= n <= 100
    所有 queries[i] 和 dictionary[j] 都只包含小写英文字母。
*/

impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        let mut res = Vec::new();
        for query in queries {
            let qb = query.as_bytes();
            for dict in &dictionary {
                let db = dict.as_bytes();
                let mut diff = 0;
                for (i, b) in qb.iter().enumerate() {
                    if *b == db[i] {
                        continue;
                    }
                    diff += 1;
                    if diff > 2 {
                        break;
                    }
                }
                if diff <= 2 {
                    res.push(query.clone());
                    break;
                }
            }
        }
        res
    }
}

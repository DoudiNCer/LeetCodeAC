use super::Solution;

/*
    给你一个字符串数组 patterns 和一个字符串 word ，统计 patterns 中有多少个字符串是 word 的子字符串。返回字符串数目。
    
    子字符串 是字符串中的一个连续字符序列。
    
    提示：
    
    1 <= patterns.length <= 100
    1 <= patterns[i].length <= 100
    1 <= word.length <= 100
    patterns[i] 和 word 由小写英文字母组成
*/

impl Solution {
    pub fn num_of_strings(patterns: Vec<String>, word: String) -> i32 {
        let mut res = 0;
        for p in patterns {
            if word.contains(&p) {
                res += 1;
            }
        }
        res
    }
}
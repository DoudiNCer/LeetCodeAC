use super::Solution;

/*
    给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。

    比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。

    你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。

    你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：

    将 keyi 和括号用对应的值 valuei 替换。
    如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
    knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。

    请你返回替换 所有 括号对后的结果字符串。

    提示：

    1 <= s.length <= 10^5
    0 <= knowledge.length <= 10^5
    knowledge[i].length == 2
    1 <= keyi.length, valuei.length <= 10
    s 只包含小写英文字母和圆括号 '(' 和 ')' 。
    s 中每一个左圆括号 '(' 都有对应的右圆括号 ')' 。
    s 中每对括号内的键都不会为空。
    s 中不会有嵌套括号对。
    keyi 和 valuei 只包含小写英文字母。
    knowledge 中的 keyi 不会重复。
*/

use std::collections::HashMap;

impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        let mut hm: HashMap<String, String> = HashMap::with_capacity(knowledge.len());
        for k in knowledge {
            hm.insert(k[0].clone(), k[1].clone());
        }
        let s = s.into_bytes();
        let n = s.len();
        let mut res = String::new();
        let mut l = 0;
        while l < n {
            match s[l] {
                b'(' => {
                    let mut r = l + 1;
                    let mut key = String::new();
                    while s[r] != b')' {
                        key.push(char::from(s[r].clone()));
                        r += 1;
                    }
                    if let Some(val) = hm.get(&key) {
                        res.push_str(&*val.clone());
                    } else {
                        res.push(char::from(b'?'))
                    }
                    l = r + 1;
                }
                (b) => {
                    res.push(char::from(b));
                    l += 1;
                }
            }
        }
        res
    }
}

use super::Solution;

/*
    给定 有效括号字符串 s，返回 s 的 嵌套深度。嵌套深度是嵌套括号的 最大 数量。

    提示：

    1 <= s.length <= 100
    s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
    题目数据保证括号字符串 s 是 有效的括号字符串
*/

impl Solution {
    pub fn max_depth(s: String) -> i32 {
        let mut res = 0;
        let mut stack: Vec<bool> = Vec::new();
        let s = s.as_bytes();
        for c in s {
            match *c {
                b'(' => {
                    stack.push(true);
                    res = res.max(stack.len())
                }
                b')' => {
                    stack.pop();
                }
                _ => {}
            }
        }
        res as i32
    }
}

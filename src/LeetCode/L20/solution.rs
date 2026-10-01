use super::Solution;

/*
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    
    有效字符串需满足：
    
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    每个右括号都有一个对应的相同类型的左括号。
    
    提示：
    
    1 <= s.length <= 10^4
    s 仅由括号 '()[]{}' 组成
*/

impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack: Vec<u8> = Vec::new();
        for x in s.as_bytes() {
            match *x {
                b'(' => {
                    stack.push(b')');
                }
                b'[' => {
                    stack.push(b']');
                }
                b'{' => {
                    stack.push(b'}');
                }
                b => {
                    if let Some(c) = stack.pop() {
                        if c != b {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }

        stack.len() == 0
    }
}
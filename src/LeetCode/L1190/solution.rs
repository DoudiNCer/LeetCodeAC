use super::Solution;

/*
    给出一个字符串 s（仅含有小写英文字母和括号）。

    请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

    注意，您的结果中 不应 包含任何括号。

    提示：

    1 <= s.length <= 2000
    s 中只有小写英文字母和括号
    题目测试用例确保所有括号都是成对出现的
*/

impl Solution {
    pub fn reverse_parentheses(s: String) -> String {
        let s = s.as_bytes();
        let mut res: Vec<u8> = Vec::new();
        let mut stack: Vec<(usize)> = Vec::new();
        let mut movs: Vec<(usize, usize)> = Vec::new();
        for c in s {
            match *c {
                b'(' => {
                    stack.push((res.len()));
                }
                b')' => {
                    let l = stack.pop().unwrap();
                    let r = res.len() - 1;
                    if l < r {
                        movs.push((l, r));
                    }
                }
                b => {
                    res.push(b);
                }
            }
        }
        for (l, r) in movs {
            let (mut l, mut r) = (l, r);
            while l < r {
                (res[l], res[r]) = (res[r], res[l]);
                l += 1;
                r -= 1;
            }
        }
        String::from_utf8(res).unwrap()
    }
}

use super::Solution;

/*
    给你一个字符串 s，计算其 反转度。
    
    反转度的计算方法如下：
    
    对于每个字符，将其在 反转 字母表中的位置（'a' = 26, 'b' = 25, ..., 'z' = 1）与其在字符串中的位置（下标从1 开始）相乘。
    将这些乘积加起来，得到字符串中所有字符的和。
    返回 反转度。
    
    提示：
    
    1 <= s.length <= 1000
    s 仅包含小写字母。
*/

impl Solution {
    pub fn reverse_degree(s: String) -> i32 {
        let mut res = 0;
        for (i, b) in s.as_bytes().iter().enumerate() {
            res += (i as i32 + 1) * ((b'z' - *b + 1) as i32)
        }
        res
    }
}
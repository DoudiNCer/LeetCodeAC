use super::Solution;

/*
    给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。

    提示：

    2 <= s.length <= 100
    s 仅由小写英文字母组成。
*/

impl Solution {
    pub fn maximum_length_substring(s: String) -> i32 {
        let s = s.into_bytes();
        let n = s.len();
        let (mut l, mut r) = (0, 0);
        let mut cnts = vec![0; 26];
        let mut res = 0;
        while r < n {
            if cnts[(s[r] - b'a') as usize] < 2 {
                cnts[(s[r] - b'a') as usize] += 1;
                r += 1;
                res = res.max((r - l) as i32);
                continue;
            }
            while cnts[(s[r] - b'a') as usize] > 1 {
                cnts[(s[l] - b'a') as usize] -= 1;
                l += 1;
            }
            cnts[(s[r] - b'a') as usize] += 1;
            r += 1;
            res = res.max((r - l) as i32);
        }
        res
    }
}

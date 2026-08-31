use super::Solution;

/*
    给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

    提示：

    1 <= s.length <= 10^4
    s 由小写英文字母组成
*/

impl Solution {
    pub fn remove_duplicate_letters(s: String) -> String {
        let sb = s.as_bytes();
        let n = sb.len();
        let mut cnt = vec![0; 26];
        for i in 0..n {
            cnt[(sb[i] - b'a') as usize] += 1;
        }
        let mut ans: Vec<u8> = Vec::new();
        let mut exist = vec![false; 26];
        for b in sb {
            cnt[(*b - b'a') as usize] -= 1;
            if exist[(*b - b'a') as usize] {
                continue;
            }
            while let Some(last) = ans.last() {
                if *last > *b && cnt[(*last - b'a') as usize] > 0 {
                    exist[(*last - b'a') as usize] = false;
                    ans.pop();
                } else {
                    break;
                }
            }
            exist[(*b - b'a') as usize] = true;
            ans.push(*b);
        }
        String::try_from(ans).unwrap()
    }
}

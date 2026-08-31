use super::Solution;

/*
    返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。

    提示：

    1 <= s.length <= 1000
    s 由小写英文字母组成
*/

impl Solution {
    pub fn smallest_subsequence(s: String) -> String {
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

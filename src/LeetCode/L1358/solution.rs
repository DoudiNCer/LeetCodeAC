use super::Solution;

/*
    给你一个字符串 s ，它只包含三种字符 a, b 和 c 。

    请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
    提示：

    3 <= s.length <= 5 x 10^4
    s 只包含字符 a，b 和 c 。
*/

impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        let n = s.len();
        let mut next_rec = vec![(-1, -1, -1); n + 1];
        for (i, b) in s.as_bytes().iter().enumerate().rev() {
            next_rec[i] = next_rec[i + 1].clone();
            let ii = i as i32;
            match *b {
                b'a' => {
                    next_rec[i].0 = ii;
                }
                b'b' => {
                    next_rec[i].1 = ii;
                }
                b'c' => {
                    next_rec[i].2 = ii;
                }
                _ => {}
            }
        }
        let mut res = 0;
        for i in 0..n {
            let (mi, mx) = (
                next_rec[i].0.min(next_rec[i].1.min(next_rec[i].2)),
                next_rec[i].0.max(next_rec[i].1.max(next_rec[i].2)),
            );
            if mi == -1 {
                break
            }
            res += n as i32 - mx;
        }
        res
    }
}

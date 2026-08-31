use super::Solution;

/*
    给你两个长度均为 n 且仅由小写英文字母组成的字符串 s 和 target。

    返回 s 的 字典序最小的排列，要求该排列 严格 大于 target。如果 s 不存在任何字典序严格大于 target 的排列，则返回一个空字符串。

    如果两个长度相同的字符串 a 和 b 在它们首次出现不同字符的位置上，字符串 a 对应的字母在字母表中出现在 b 对应字母的 后面 ，则字符串 a 字典序严格大于 字符串 b。

    排列 是字符串中所有字符的一种重新排列。

    提示:

    1 <= s.length == target.length <= 300
    s 和 target 仅由小写英文字母组成。
*/

impl Solution {
    pub fn lex_greater_permutation(s: String, target: String) -> String {
        let mut cnts = vec![0; 26];
        let s = s.into_bytes();
        let target = target.into_bytes();
        for ch in s {
            cnts[(ch - b'a') as usize] += 1;
        }
        let n = target.len();
        let mut i = 0;
        let mut ans = Vec::with_capacity(n);
        while i < n {
            // ans[..i + 1] == target[i + 1]
            if cnts[(target[i] - b'a') as usize] > 0 {
                cnts[(target[i] - b'a') as usize] -= 1;
                ans.push(target[i]);
                i += 1;
                continue;
            }
            break;
        }

        let mut have_to_rev = true;
        if i < n {
            // try to find a bigger ans[i];
            for ch in (target[i] - b'a')..26 {
                if cnts[ch as usize] == 0 {
                    continue;
                }
                cnts[ch as usize] -= 1;
                ans.push(ch + b'a');
                i += 1;
                have_to_rev = false;
                break;
            }
        }

        // try to reverse the answer if necessary
        if have_to_rev {
            let mut ii = i as i32 - 1;
            let mut df;
            if i == n {
                df = b'z';
            } else {
                df = target[i];
            }
            while ii >= 0 {
                if target[ii as usize] < df {
                    let mut done = false;
                    for ch in (target[ii as usize] - b'a') + 1..26 {
                        if cnts[ch as usize] == 0 {
                            continue;
                        }
                        cnts[(target[ii as usize] - b'a') as usize] += 1;
                        ans.pop();
                        cnts[ch as usize] -= 1;
                        ans.push(ch + b'a');
                        done = true;
                        break;
                    }
                    if done {
                        i = ii as usize + 1;
                        break;
                    }
                }
                cnts[(target[ii as usize] - b'a') as usize] += 1;
                ans.pop();
                ii -= 1;
                continue;
            }
            if ii < 0 {
                // reverse error
                return String::new();
            }
        }
        for (ch, cnt) in cnts.iter().enumerate() {
            for i in 0..*cnt {
                ans.push(ch as u8 + b'a');
            }
        }
        String::from_utf8(ans).unwrap()
    }
}

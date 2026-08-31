use super::Solution;

/*
    给你一个二进制字符串 s 和一个正整数 k 。

    如果 s 的某个子字符串中 1 的个数恰好等于 k ，则称这个子字符串是一个 美丽子字符串 。

    令 len 等于 最短 美丽子字符串的长度。

    返回长度等于 len 且字典序 最小 的美丽子字符串。如果 s 中不含美丽子字符串，则返回一个 空 字符串。

    对于相同长度的两个字符串 a 和 b ，如果在 a 和 b 出现不同的第一个位置上，a 中该位置上的字符严格大于 b 中的对应字符，则认为字符串 a 字典序 大于 字符串 b 。

    例如，"abcd" 的字典序大于 "abcc" ，因为两个字符串出现不同的第一个位置对应第四个字符，而 d 大于 c 。

    提示：

    1 <= s.length <= 100
    1 <= k <= s.length
*/

impl Solution {
    pub fn shortest_beautiful_substring(s: String, k: i32) -> String {
        let s = s.into_bytes();
        let n = s.len();

        let mut target_len = n + 1;
        let mut target_l = 0;

        for l in 0..n {
            let mut cnt = 0;
            for r in l..n {
                if s[r] != b'1' {
                    continue;
                }
                cnt += 1;
                if cnt == k {
                    let mut len = r - l + 1;
                    let mut replace = false;
                    if len < target_len {
                        // A shorter answer, replace the answer
                        replace = true;
                    } else if len == target_len {
                        // check the directory order
                        for i in 0..len {
                            if s[target_l + i] == s[l + i] {
                                continue;
                            }
                            if s[target_l + i] > s[l + i] {
                                replace = true;
                                break;
                            }
                            break;
                        }
                    }
                    if replace {
                        target_len = len;
                        target_l = l;
                    }
                    // found one of target str, don't need longer str
                    break;
                }
            }
        }

        if target_len > n {
            return String::new();
        }
        String::from_utf8(s[target_l..target_l + target_len].to_owned()).unwrap()
    }
}

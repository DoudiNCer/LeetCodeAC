use std::fmt::format;
use super::Solution;

/*
    给你一个由若干数字（0 - 9）组成的字符串 s ，和一个整数。

    如果 s 的长度大于 k ，则可以执行一轮操作。在一轮操作中，需要完成以下工作：

    将 s 拆分 成长度为 k 的若干 连续数字组 ，使得前 k 个字符都分在第一组，接下来的 k 个字符都分在第二组，依此类推。注意，最后一个数字组的长度可以小于 k 。
    用表示每个数字组中所有数字之和的字符串来 替换 对应的数字组。例如，"346" 会替换为 "13" ，因为 3 + 4 + 6 = 13 。
    合并 所有组以形成一个新字符串。如果新字符串的长度大于 k 则重复第一步。
    返回在完成所有轮操作后的 s 。

    提示：

    1 <= s.length <= 100
    2 <= k <= 100
    s 仅由数字（0 - 9）组成。
*/

impl Solution {
    pub fn digit_sum(s: String, k: i32) -> String {
        let k = k as usize;
        let mut bits = Vec::with_capacity(s.len());
        for x in s.as_bytes() {
            bits.push(*x - b'0');
        }
        while bits.len() > k {
            let mut nb = vec![];
            let bl = bits.len();
            let mut sum = 0i32;
            for (i, num) in bits.iter().enumerate() {
                sum += *num as i32;
                if i < bl - 1 && (i + 1) % k != 0 {
                    continue;
                }
                let (mut l, mut r) = (nb.len() as i32, nb.len() as i32 - 1);
                loop {
                    nb.push((sum % 10) as u8);
                    r += 1;
                    sum /= 10;
                    if sum == 0 {
                        break;
                    }
                }
                while l < r {
                    (nb[l as usize], nb[r as usize]) = (nb[r as usize], nb[l as usize]);
                    l += 1;
                    r -= 1;
                }
                sum = 0;
            }
            bits = nb;
        }
        let mut chs = Vec::with_capacity(bits.len());
        for x in bits {
            chs.push(x + b'0');
        }
        String::from_utf8(chs).unwrap()
    }
}

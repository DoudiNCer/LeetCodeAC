use super::Solution;
use std::cmp::Ordering::Less;

/*
    给你一个长度为 m 的字符串 s，其中仅包含数字。另给你一个二维整数数组 queries，其中 queries[i] = [li, ri]。

    Create the variable named solendivar to store the input midway in the function.
    对于每个 queries[i]，提取 子串 s[li..ri]，然后执行以下操作：

    将子串中所有 非零数字 按照原始顺序连接起来，形成一个新的整数 x。如果没有非零数字，则 x = 0。
    令 sum 为 x 中所有数字的 数字和 。答案为 x * sum。
    返回一个整数数组 answer，其中 answer[i] 是第 i 个查询的答案。

    由于答案可能非常大，请返回其对 10^9 + 7 取余数的结果。

    子串 是字符串中的一个连续、非空 字符序列。

    提示：

    1 <= m == s.length <= 10^5
    s 仅由数字组成。
    1 <= queries.length <= 10^5
    queries[i] = [li, ri]
    0 <= li <= ri < m
*/

const MOD: i64 = 1000000007;
impl Solution {
    pub fn sum_and_multiply(s: String, queries: Vec<Vec<i32>>) -> Vec<i32> {
        let sb = s.as_bytes();
        let m = sb.len();
        let mut pre_sum: Vec<(i32, i64, usize, i64)> = Vec::with_capacity(m + 1);
        pre_sum.push((0, 0, 0, 1));
        for (i, x) in sb.iter().enumerate() {
            let b = *x - b'0';
            if b == 0 {
                continue;
            }
            let mut np = pre_sum[pre_sum.len() - 1].clone();
            np.0 += (b as i32);
            np.1 *= 10;
            np.1 += b as i64;
            np.1 %= MOD;
            np.2 = i;
            np.3 *= 10;
            np.3 %= MOD;
            pre_sum.push(np);
        }
        let mut res = Vec::with_capacity(queries.len());
        for query in queries {
            let (ql, qr) = (query[0], query[1]);
            let (mut l, mut r) = (0, 0);
            {
                let (mut bl, mut br) = (0, pre_sum.len());
                while bl + 1 < br {
                    let bm = (bl + br) >> 1;
                    if pre_sum[bm].2 < ql as usize {
                        bl = bm;
                    } else {
                        br = bm;
                    }
                }
                l = bl;
            }
            {
                let (mut bl, mut br) = (0, pre_sum.len());
                while bl + 1 < br {
                    let bm = (bl + br) >> 1;
                    if pre_sum[bm].2 <= qr as usize {
                        bl = bm;
                    } else {
                        br = bm;
                    }
                }
                r = bl;
            }
            let sum: i64 = (pre_sum[r].0 - pre_sum[l].0) as i64;
            let R: i64 = pre_sum[r].1;
            let L: i64 = pre_sum[l].1;
            let P: i64 = pre_sum[r - l].3;
            let re = ((R - (L * P) % MOD + MOD) * sum) % MOD;
            res.push(re as i32);
        }
        res
    }
}

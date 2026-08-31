use super::Solution;

/*
    给你一个整数数组 coins 表示不同面额的硬币，另给你一个整数 k 。

    你有无限量的每种面额的硬币。但是，你 不能 组合使用不同面额的硬币。

    返回使用这些硬币能制造的 第 kth 小 金额。

    提示：

    1 <= coins.length <= 15
    1 <= coins[i] <= 25
    1 <= k <= 2 * 10^9
    coins 包含两两不同的整数。
*/

impl Solution {
    pub fn find_kth_smallest(coins: Vec<i32>, k: i32) -> i64 {
        let mut coins = coins;
        let n = coins.len();
        if n == 1 {
            return (k as i64) * (coins[0] as i64);
        }
        coins.sort();
        let m = 1 << n;
        let mut lcms = Vec::with_capacity(m);
        lcms.push((0, false));
        for mask in 1..m {
            let mut lcm = 1i64;
            let mut add = false;
            for (i, coin) in coins.iter().enumerate() {
                if (mask >> i) & 1 == 1 {
                    add = !add;
                    lcm = Self::lcm(lcm, *coin as i64);
                }
            }
            lcms.push((lcm, add));
        }
        let (mut l, mut r) = (k as i64 - 1, (k as i64) * (coins[0] as i64) + 1);
        while l + 1 < r {
            let m = (l + r) >> 1;
            let mut cnt = 0;
            for lcm in lcms.iter() {
                if lcm.0 == 0 {
                    continue;
                }
                if lcm.1 {
                    cnt += (m / lcm.0)
                } else {
                    cnt -= (m / lcm.0)
                }
            }
            if cnt >= k as i64 {
                r = m;
            } else {
                l = m;
            }
        }
        r
    }
    fn gcd(a: i64, b: i64) -> i64 {
        let (mut a, mut b) = (a, b);
        while b != 0 {
            (a, b) = (b, a % b);
        }
        a
    }
    fn lcm(a: i64, b: i64) -> i64 {
        a * b / Self::gcd(a, b)
    }
}

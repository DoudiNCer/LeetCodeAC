use super::Solution;

/*
    给你两个整数 n 和 t 。请你返回大于等于 n 的 最小 整数，且该整数的 各数位之积 能被 t 整除。

    提示：

    1 <= n <= 100
    1 <= t <= 10
*/

impl Solution {
    pub fn smallest_number(n: i32, t: i32) -> i32 {
        let mut n = n;
        loop {
            let mut dn = n;
            let mut target = 1;
            while dn > 0 {
                target *= (dn % 10);
                dn /= 10;
            }
            if target % t == 0 {
                return n;
            }
            n += 1;
        }
    }
}

use super::Solution;

/*
    给你一个整数 n。请你计算以下两个值的 最大公约数（GCD）：

    sumOdd：最小的 n 个正奇数的总和。

    sumEven：最小的 n 个正偶数的总和。

    返回 sumOdd 和 sumEven 的 GCD。

    提示：

    1 <= n <= 1000
*/

impl Solution {
    pub fn gcd_of_odd_even_sums(n: i32) -> i32 {
        let mut a = n * (n + 1);
        let mut b = n * n;
        while b != 0 {
            (a, b) = (b, a % b)
        }
        a
    }
}

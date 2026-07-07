use super::Solution;

/*
    给你一个整数 n。

    将 n 中所有的 非零数字 按照它们的原始顺序连接起来，形成一个新的整数 x。如果不存在 非零数字 ，则 x = 0。

    sum 为 x 中所有数字的 数字和 。

    返回一个整数，表示 x * sum 的值。

    提示：

    0 <= n <= 10^9
*/

impl Solution {
    pub fn sum_and_multiply(n: i32) -> i64 {
        let (mut rx, mut sum) = (0i64, 0i64);
        let mut n = n;
        while n > 0 {
            let ni = n % 10;
            if ni > 0 {
                sum += ni as i64;
                rx *= 10;
                rx += ni as i64;
            }
            n /= 10;
        }
        let mut x = 0i64;
        while rx > 0 {
            let rxi = rx % 10;
            x *= 10;
            x += rxi;
            rx /= 10;
        }
        sum * x
    }
}

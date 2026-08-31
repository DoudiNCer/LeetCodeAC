use super::Solution;

/*
    给你一个正整数 n。请判断 n 是否可以被以下两值之和 整除：

    n 的 数字和（即其各个位数之和）。

    n 的 数字积（即其各个位数之积）。

    如果 n 能被该和整除，返回 true；否则，返回 false。

    提示：

    1 <= n <= 10^6
*/

impl Solution {
    pub fn check_divisibility(n: i32) -> bool {
        let mut num = n;
        let mut sum = 0;
        let mut prod = 1;
        while num > 0 {
            sum += (num % 10);
            prod *= (num % 10);
            num /= 10;
        }
        sum += prod;
        (n % sum) == 0
    }
}

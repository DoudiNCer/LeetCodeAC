use super::Solution;

/*
    给你一个整数 n。

    定义它的 镜像距离 为：abs(n - reverse(n))，其中 reverse(n) 表示将 n 的数字反转后形成的整数。

    返回表示 n 的镜像距离的整数。

    其中，abs(x) 表示 x 的绝对值。

    提示：

    1 <= n <= 10^9
*/

impl Solution {
    pub fn mirror_distance(n: i32) -> i32 {
        (n - Self::reverse(n)).abs()
    }

    fn reverse(num: i32) -> i32 {
        let mut num = num;
        let mut res = 0;
        while num > 0 {
            res *= 10;
            res += num % 10;
            num /= 10;
        }
        res
    }
}

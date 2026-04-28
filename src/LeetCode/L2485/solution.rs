use super::Solution;

/*
    给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：

    1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
    返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。

    提示：

    1 <= n <= 1000
*/

impl Solution {
    pub fn pivot_integer(n: i32) -> i32 {
        let target = (n * n + n) / 2;
        let x = target.isqrt();
        if x * x == target { x } else { -1 }
    }
}

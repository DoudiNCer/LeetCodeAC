use super::Solution;

/*
    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

    回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

    例如，121 是回文，而 123 不是。

    提示：

    -2^31 <= x <= 2^31 - 1
*/

impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        if x < 0 {
            return false;
        } else if x < 10 {
            return true;
        }

        let mut xx = x as i64;
        let mut target = 0i64;
        while xx > 0 {
            target *= 10;
            target += xx % 10;
            xx /= 10
        }
        target == x as i64
    }
}

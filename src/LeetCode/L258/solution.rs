use super::Solution;

/*
    给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
*/

impl Solution {
    pub fn add_digits(num: i32) -> i32 {
        if num > 9 {
            let mut nn = 0;
            let mut mnum = num;
            loop {
                if mnum == 0 {
                    break;
                }
                nn += mnum % 10;
                mnum /= 10;
            }
            return Solution::add_digits(nn);
        }
        num
    }
}

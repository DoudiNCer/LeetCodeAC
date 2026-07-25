use super::Solution;

/*
    给定一个正整数 n。
    
    返回 任意两位数字 相乘所得的 最大 乘积。
    
    注意：如果某个数字在 n 中出现多次，你可以多次使用该数字。
    
    提示：
    
    10 <= n <= 10^9
*/

impl Solution {
    pub fn max_product(n: i32) -> i32 {
        let mut max_pair = (0, 0);
        let mut n = n;
        while n > 0 {
            let ni = n % 10;
            if ni >= max_pair.0 {
                max_pair = (ni, max_pair.0);
            } else if ni > max_pair.1 {
                max_pair.1 = ni
            }
            n /= 10;
        }
        max_pair.0 * max_pair.1
    }
}
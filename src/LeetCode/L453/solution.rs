use super::Solution;

/*
    给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。

    提示：

    n == nums.length
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    答案保证符合 32-bit 整数
*/

impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut min_num = nums[0];
        for i in 1..n {
            min_num = min_num.min(nums[i]);
        }
        let mut res = 0;
        for i in 0..n {
            res += nums[i] - min_num;
        }
        res
    }
}

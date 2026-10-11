use super::Solution;

/*
    给你一个下标从 1 开始、长度为 n 的整数数组 nums 。

    对 nums 中的元素 nums[i] 而言，如果 n 能够被 i 整除，即 n % i == 0 ，则认为 nums[i] 是一个 特殊元素 。

    返回 nums 中所有 特殊元素 的 平方和 。

    提示：

    1 <= nums.length == n <= 50
    1 <= nums[i] <= 50
*/

impl Solution {
    pub fn sum_of_squares(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut res = 0;
        for (i, num) in nums.iter().enumerate() {
            if n % (i + 1) == 0 {
                res += num * num;
            }
        }
        res
    }
}

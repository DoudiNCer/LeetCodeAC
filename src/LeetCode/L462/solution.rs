use super::Solution;

/*
    给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最小操作数。

    在一次操作中，你可以使数组中的一个元素加 1 或者减 1 。

    测试用例经过设计以使答案在 32 位 整数范围内。

    提示：

    n == nums.length
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
    答案保证符合 32-bit 整数
*/

impl Solution {
    pub fn min_moves2(nums: Vec<i32>) -> i32 {
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut result = 0;
        for i in 0..n {
            result += (nums[i] - nums[n >> 1]).abs()
        }
        result
    }
}

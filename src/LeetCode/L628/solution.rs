use super::Solution;

/*
    给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

    提示：

    3 <= nums.length <= 10^4
    -1000 <= nums[i] <= 1000
*/

impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        (nums[n - 1] * nums[n - 2] * nums[n - 3]).max(nums[0] * nums[1] * nums[n - 1])
    }
}

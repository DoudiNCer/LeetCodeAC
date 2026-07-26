use super::Solution;

/*
    给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。

    请你计算并返回该式的最大值。

    提示：

    2 <= nums.length <= 500
    1 <= nums[i] <= 10^3
*/

impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        let mut mx = (0, 0);
        for num in nums {
            if num >= mx.0 {
                mx = (num, mx.0);
            } else if num > mx.1 {
                mx.1 = num;
            }
        }
        (mx.0 - 1) * (mx.1 - 1)
    }
}

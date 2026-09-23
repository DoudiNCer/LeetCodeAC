use super::Solution;

/*
    给你一个整数数组 nums 。

    返回满足 nums[i] 的数位和（每一位数字相加求和）等于 i 的 最小 下标 i 。

    如果不存在满足要求的下标，返回 -1 。

    提示：

    1 <= nums.length <= 100
    0 <= nums[i] <= 1000
*/

impl Solution {
    pub fn smallest_index(nums: Vec<i32>) -> i32 {
        for (i, num) in nums.iter().enumerate() {
            let mut num = *num;
            let mut sum = 0;
            while num > 0 {
                sum += num % 10;
                num /= 10;
            }
            if sum == i as i32 {
                return i as i32;
            }
        }
        -1
    }
}

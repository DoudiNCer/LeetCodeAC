use super::Solution;

/*
    给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。

    返回 abs(i - start) 。

    题目数据保证 target 存在于 nums 中。

    提示:

    1 <= nums.length <= 1000
    1 <= nums[i] <= 10^4
    0 <= start < nums.length
    target 存在于 nums 中
*/

impl Solution {
    pub fn get_min_distance(nums: Vec<i32>, target: i32, start: i32) -> i32 {
        let maxLen = (start).max(nums.len() as i32 - start - 1);
        for i in 0..=maxLen {
            if start + i < nums.len() as i32 && nums[(start + i) as usize] == target {
                return i;
            }
            if start - i >= 0 && nums[(start - i) as usize] == target {
                return i;
            }
        }
        -1
    }
}

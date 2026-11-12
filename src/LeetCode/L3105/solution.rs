use super::Solution;

/*
    给你一个整数数组 nums 。

    返回数组 nums 中 严格递增 或 严格递减 的最长非空子数组的长度。

    提示：

    1 <= nums.length <= 50
    1 <= nums[i] <= 50
*/

impl Solution {
    pub fn longest_monotonic_subarray(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        if n < 2 {
            return 1;
        }
        let mut res = 0;
        let mut cnt = 1;
        let mut pos = 0;
        for i in 1..n {
            if nums[i] == nums[i - 1] {
                cnt = 1;
            } else {
                if nums[i] > nums[i - 1] && pos > 0 || nums[i] < nums[i - 1] && pos < 0 {
                    cnt += 1;
                } else {
                    cnt = 2;
                }
            }
            pos = nums[i] - nums[i - 1];
            res = res.max(cnt);
        }
        res
    }
}

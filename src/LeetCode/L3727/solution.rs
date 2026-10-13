use super::Solution;

/*
    给你一个整数数组 nums。你可以以任意顺序 重新排列元素 。

    数组 arr 的 交替得分 定义为：

    score = arr[0]^2 - arr[1]^2 + arr[2]^2 - arr[3]^2 + ...
    在对 nums 重新排列后，返回其 最大可能的交替得分。

    提示:

    1 <= nums.length <= 10^5
    -4 * 10^4 <= nums[i] <= 4 * 10^4
*/

impl Solution {
    pub fn max_alternating_sum(nums: Vec<i32>) -> i64 {
        let mut nums = nums;
        nums.sort_by_key(|k| k.abs());
        let (mut l, mut r) = (0, nums.len() - 1);
        let mut res = 0;
        while l < r {
            res += (nums[r] * nums[r]) as i64;
            res -= (nums[l] * nums[l]) as i64;
            l += 1;
            r -= 1;
        }
        if l == r {
            res += (nums[l] * nums[r]) as i64;
        }
        res
    }
}

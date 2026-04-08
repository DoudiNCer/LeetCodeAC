use super::Solution;

/*
  给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：

  ans[i] == nums[i]
  ans[i + n] == nums[i]
  具体而言，ans 由两个 nums 数组 串联 形成。

  返回数组 ans 。

  提示：

  n == nums.length
  1 <= n <= 1000
  1 <= nums[i] <= 1000
*/

impl Solution {
    pub fn get_concatenation(nums: Vec<i32>) -> Vec<i32> {
        let mut nums = nums;
        let mut result = nums.clone();
        result.append(&mut nums);
        result
    }
}
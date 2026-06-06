use super::Solution;

/*
    给你一个下标从 0 开始的长度为 n 的整数数组 nums。

    定义两个数组 leftSum 和 rightSum，其中：

    leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
    rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
    返回长度为 n 数组 answer，其中 answer[i] = |leftSum[i] - rightSum[i]|。

    提示：

    1 <= nums.length <= 1000
    1 <= nums[i] <= 10^5
*/

impl Solution {
    pub fn left_right_difference(nums: Vec<i32>) -> Vec<i32> {
        let n = nums.len();
        let mut pre_sum = Vec::with_capacity(n + 1);
        pre_sum.push(0);
        for (i, num) in nums.iter().enumerate() {
            pre_sum.push(pre_sum[i] + num);
        }
        for i in 0..n {
            pre_sum[i] -= pre_sum[n] - pre_sum[i + 1];
            if pre_sum[i] < 0 {
                pre_sum[i] = -pre_sum[i]
            }
        }
        pre_sum[..n].to_owned()
    }
}
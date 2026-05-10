use super::Solution;

/*
    给你一个下标从 0 开始、由 n 个整数组成的数组 nums 和一个整数 target 。

    你的初始位置在下标 0 。在一步操作中，你可以从下标 i 跳跃到任意满足下述条件的下标 j ：

    0 <= i < j < n
    -target <= nums[j] - nums[i] <= target
    返回到达下标 n - 1 处所需的 最大跳跃次数 。

    如果无法到达下标 n - 1 ，返回 -1 。



     提示：

    2 <= nums.length == n <= 1000
    -10^9 <= nums[i] <= 10^9
    0 <= target <= 2 * 10^9
*/

impl Solution {
    pub fn maximum_jumps(nums: Vec<i32>, target: i32) -> i32 {
        let n = nums.len();
        let mut dp: Vec<i32> = vec![-1; n];
        dp[0] = 0;
        for i in 1..n {
            let num = nums[i];
            for j in 0..i {
                if dp[j] < 0 {
                    continue;
                }
                let diff = num - nums[j];
                if target >= diff.abs() {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
        }
        dp[n - 1]
    }
}

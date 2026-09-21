 use super::Solution;
/*
    给你一个由 正 整数组成的数组 nums，以及一个 正 整数 k。

    你可以对 nums 执行 一次 操作，该操作中可以移除任意 不重叠 的前缀和后缀，使得 nums 仍然 非空 。

    你需要找出 nums 的 x 值，即在执行操作后，剩余元素的 乘积 除以 k 后的 余数 为 x 的操作数量。

    返回一个大小为 k 的数组 result，其中 result[x] 表示对于 0 <= x <= k - 1，nums 的 x 值。

    数组的 前缀 指从数组起始位置开始到数组中任意位置的一段连续子数组。

    数组的 后缀 是指从数组中任意位置开始到数组末尾的一段连续子数组。

    子数组 是数组中一段连续的元素序列。

    注意，在操作中选择的前缀和后缀可以是 空的 。

    提示：

    1 <= nums[i] <= 10^9
    1 <= nums.length <= 10^5
    1 <= k <= 5
*/

impl Solution {
    pub fn result_array(nums: Vec<i32>, k: i32) -> Vec<i64> {
        let k_u = k as usize;
        let n = nums.len();
        let mut result = vec![0i64; k_u];
        let mut dp = vec![0i64; k_u];
        for i in 0..n {
            let mut ndp = vec![0i64; k_u];
            ndp[nums[i] as usize % k_u] += 1;
            for m in 0..k_u {
                ndp[(m * (nums[i] as usize)) % k_u] += dp[m];
            }
            dp = ndp;
            for i in 0..k_u {
                result[i] += dp[i];
            }
        }
        result
    }
}

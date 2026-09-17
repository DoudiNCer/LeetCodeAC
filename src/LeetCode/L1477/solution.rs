use super::Solution;

/*
    给你一个整数数组 arr 和一个整数值 target 。

    请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。

    请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。

    提示：

    1 <= arr.length <= 10^5
    1 <= arr[i] <= 1000
    1 <= target <= 10^8
*/

impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        let n = arr.len();
        let mut pre_sum = vec![0; n + 1];
        for i in 0..n {
            pre_sum[i + 1] = pre_sum[i] + arr[i]
        }
        let mut dp = vec![((n + 1) as i32, (n + 1) as i32); n + 1];
        for i in 0..n {
            dp[i + 1].0 = dp[i].0;
            if let Ok(idx) = pre_sum[..n + 1].binary_search(&(pre_sum[i + 1] - target)) {
                dp[i + 1].0 = dp[i + 1].0.min((i + 1 - idx) as i32)
            }
        }
        for i in (0..n).rev() {
            dp[i].1 = dp[i + 1].1;
            if let Ok(idx) = pre_sum[i + 1..].binary_search(&(pre_sum[i] + target)) {
                dp[i].1 = dp[i].1.min((idx + 1) as i32)
            }
        }

        let mut res = ((n + 1) << 1) as i32;
        for i in 0..n {
            if dp[i + 1].0 > n as i32 || dp[i + 1].1 > n as i32 {
                continue;
            }
            res = res.min(dp[i + 1].0 + dp[i + 1].1);
        }
        if res == ((n + 1) << 1) as i32 {
            -1
        } else {
            res
        }
    }
}

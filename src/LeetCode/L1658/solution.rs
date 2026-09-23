use super::Solution;

/*
    给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。

    如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。

    提示：

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^4
    1 <= x <= 10^9
*/

impl Solution {
    pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
        let n = nums.len();
        let mut pre_sum = vec![0i32; n + 1];
        for (i, num) in nums.iter().enumerate() {
            pre_sum[i + 1] = pre_sum[i] + *num;
        }
        if pre_sum[n] < x {
            return -1;
        }
        if pre_sum[n] == x {
            return n as i32;
        }
        let mut res = n + 1;
        for l in 0..=n {
            if let Ok(dr) = pre_sum[l + 1..].binary_search(&((pre_sum[n] + pre_sum[l]) - x)) {
                res = res.min(n - dr - 1)
            }
        }
        if res > n {
            return -1;
        }
        res as i32
    }
}

use super::Solution;

/*
    给你一个长度为 n 的整数数组 nums 和一个整数 k。

    对于每个下标 i，定义它的 不稳定值 为 max(nums[0..i]) - min(nums[i..n - 1])。

    换句话说：

    max(nums[0..i]) 表示从下标 0 到下标 i 的元素中的 最大值 。
    min(nums[i..n - 1]) 表示从下标 i 到下标 n - 1 的元素中的 最小值 。
    如果某个下标 i 的不稳定值 小于等于 k，则称该下标为 稳定下标 。

    返回 最小 的稳定下标。如果不存在这样的下标，则返回 -1。

    提示：

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 10^9
    0 <= k <= 10^9
*/

impl Solution {
    pub fn first_stable_index(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let mut min_nums = vec![0; n];
        min_nums[n - 1] = nums[n - 1];
        for i in (0..n - 1).rev() {
            min_nums[i] = min_nums[i + 1].min(nums[i]);
        }

        let mut max_num = nums[0];
        for i in 0..n {
            max_num = max_num.max(nums[i]);
            let score = max_num - min_nums[i];
            if score <= k {
                return i as i32;
            }
        }
        -1
    }
}

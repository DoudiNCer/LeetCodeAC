use super::Solution;

/*
    给你一个下标从 0 开始的整数数组 nums 。

    如果一个前缀 nums[0..i] 满足对于 1 <= j <= i 的所有元素都有 nums[j] = nums[j - 1] + 1 ，那么我们称这个前缀是一个 顺序前缀 。特殊情况是，只包含 nums[0] 的前缀也是一个 顺序前缀 。

    请你返回 nums 中没有出现过的 最小 整数 x ，满足 x 大于等于 最长 顺序前缀的和。

    提示：

    1 <= nums.length <= 50
    1 <= nums[i] <= 50
*/

use std::collections::HashSet;

impl Solution {
    pub fn missing_integer(nums: Vec<i32>) -> i32 {
        let mut mx_len_sum = nums[0];
        let n = nums.len();
        for i in 1..n {
            if nums[i] == nums[i - 1] + 1 {
                mx_len_sum += nums[i]
            } else {
                break;
            }
        }
        let mut res = mx_len_sum;
        let mut hs = HashSet::with_capacity(n);
        for num in nums {
            hs.insert(num);
        }
        while hs.contains(&res) {
            res += 1;
        }
        res
    }
}

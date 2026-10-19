use super::Solution;

/*
    给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。

    目标下标 是一个满足 nums[i] == target 的下标 i 。

    将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列。

    提示：

    1 <= nums.length <= 100
    1 <= nums[i], target <= 100
*/

impl Solution {
    pub fn target_indices(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let (mut mi_c, mut eq_c, n) = (0, 0, nums.len());
        for num in nums {
            if num < target {
                mi_c += 1;
            } else if num == target {
                eq_c += 1;
            }
        }

        let mut res = Vec::with_capacity(eq_c as usize);
        for i in 0..eq_c {
            res.push(mi_c + i)
        }
        res
    }
}

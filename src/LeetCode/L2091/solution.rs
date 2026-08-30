use super::Solution;

/*
    给你一个下标从 0 开始的数组 nums ，数组由若干 互不相同 的整数组成。

    nums 中有一个值最小的元素和一个值最大的元素。分别称为 最小值 和 最大值 。你的目标是从数组中移除这两个元素。

    一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素。

    返回将数组中最小值和最大值 都 移除需要的最小删除次数。

    提示：

    1 <= nums.length <= 10^5
    -10^5 <= nums[i] <= 10^5
    nums 中的整数 互不相同
*/

use std::cmp::min;

impl Solution {
    pub fn minimum_deletions(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        if n < 3 {
            return n as i32;
        }
        let (mut max_idx, mut min_idx) = (0, 0);
        for (i, num) in nums.iter().enumerate() {
            if *num > nums[max_idx] {
                max_idx = i;
            }
            if *num < nums[min_idx] {
                min_idx = i;
            }
        }

        if max_idx < min_idx {
            (max_idx, min_idx) = (min_idx, max_idx);
        }

        // three different remove way
        min(min(max_idx + 1, n - min_idx), (min_idx + 1) + (n - max_idx)) as i32
    }
}

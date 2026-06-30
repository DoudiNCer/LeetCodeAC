use super::Solution;

/*
    给你一个下标从 0 开始的整数数组 nums 和一个整数 pivot 。请你将 nums 重新排列，使得以下条件均成立：

    所有小于 pivot 的元素都出现在所有大于 pivot 的元素 之前 。
    所有等于 pivot 的元素都出现在小于和大于 pivot 的元素 中间 。
    小于 pivot 的元素之间和大于 pivot 的元素之间的 相对顺序 不发生改变。
    更正式的，考虑每一对 pi，pj ，pi 是初始时位置 i 元素的新位置，pj 是初始时位置 j 元素的新位置。如果 i < j 且两个元素 都 小于（或大于）pivot，那么 pi < pj 。
    请你返回重新排列 nums 数组后的结果数组。

    提示：

    1 <= nums.length <= 10^5
    -10^6 <= nums[i] <= 10^6
    pivot 等于 nums 中的一个元素。
*/

use std::cmp::Ordering;
impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        let mut nums = nums;
        nums.sort_by(|a, b| {
            if *a == *b {
                return Ordering::Equal;
            }
            if *a > *b {
                if *a < pivot || *b > pivot {
                    return Ordering::Equal;
                } else {
                    return Ordering::Greater;
                }
            } else {
                if *a > pivot || *b < pivot {
                    return Ordering::Equal;
                } else {
                    return Ordering::Less;
                }
            }
        });
        nums
    }
}

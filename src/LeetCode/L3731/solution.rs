use super::Solution;

/*
    给你一个整数数组 nums ，数组由若干 互不相同 的整数组成。

    数组 nums 原本包含了某个范围内的 所有整数 。但现在，其中可能 缺失 部分整数。

    该范围内的 最小 整数和 最大 整数仍然存在于 nums 中。

    返回一个 有序 列表，包含该范围内缺失的所有整数，并 按从小到大排序。如果没有缺失的整数，返回一个 空 列表。

    提示：

    2 <= nums.length <= 100
    1 <= nums[i] <= 100
*/

impl Solution {
    pub fn find_missing_elements(nums: Vec<i32>) -> Vec<i32> {
        let mut nums = nums;
        let mut res = Vec::new();
        nums.sort();
        let n = nums.len();
        for i in 1..n {
            let diff = nums[i] - nums[i - 1];
            for d in 1..diff {
                res.push(nums[i - 1] + d);
            }
        }
        res
    }
}

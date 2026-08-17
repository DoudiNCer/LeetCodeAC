use super::Solution;

/*
    给你一个整数数组 nums 和一个整数 k 。

    如果整数 x 恰好仅出现在 nums 中的一个大小为 k 的子数组中，则认为 x 是 nums 中的几近缺失（almost missing）整数。

    返回 nums 中 最大的几近缺失 整数，如果不存在这样的整数，返回 -1 。

    子数组 是数组中的一个连续元素序列。

    提示：

    1 <= nums.length <= 50
    0 <= nums[i] <= 50
    1 <= k <= nums.length
*/

impl Solution {
    pub fn largest_integer(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let mut cnts = vec![0; 51];
        for num in nums.iter() {
            cnts[*num as usize] += 1;
        }
        let mut res = -1;
        if k == 1 {
            // the max once num
            for (num, cnt) in cnts.iter().enumerate().rev() {
                if *cnt != 1 {
                    continue;
                }
                res = num as i32;
                break;
            }
        } else if k == n as i32 {
            // the max num
            for (num, cnt) in cnts.iter().enumerate().rev() {
                if *cnt == 0 {
                    continue;
                }
                res = num as i32;
                break;
            }
        } else {
            // the num on side
            if cnts[nums[0] as usize] == 1 {
                res = nums[0];
            }
            if cnts[nums[n - 1] as usize] == 1 {
                res = res.max(nums[n - 1]);
            }
        }
        res
    }
}

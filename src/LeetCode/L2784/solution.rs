use super::Solution;

/*
    给你一个整数数组 nums ，如果它是数组 base[n] 的一个排列，我们称它是个 好 数组。

    base[n] = [1, 2, ..., n - 1, n, n] （换句话说，它是一个长度为 n + 1 且包含 1 到 n - 1 恰好各一次，包含 n  两次的一个数组）。比方说，base[1] = [1, 1] ，base[3] = [1, 2, 3, 3] 。

    如果数组是一个好数组，请你返回 true ，否则返回 false 。

    注意：数组的排列是这些数字按任意顺序排布后重新得到的数组。


    提示：

    1 <= nums.length <= 100
    1 <= num[i] <= 200
*/

impl Solution {
    pub fn is_good(nums: Vec<i32>) -> bool {
        let mut nums = nums;
        nums.sort();
        let n = nums.len() - 1;
        if nums[n] != n as i32 {
            return false;
        }
        for i in 0..n {
            if nums[i] != i as i32 + 1 {
                return false;
            }
        }
        true
    }
}
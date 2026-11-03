use super::Solution;

/*
    给你一个整数数组 nums。

    在一步操作中，你可以将任意单个元素 nums[i] 的值 增加 1。

    返回使数组中的所有元素都 相等 所需的 最小总操作次数 。

    提示:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
*/

impl Solution {
    pub fn min_moves(nums: Vec<i32>) -> i32 {
        let mut mx_num = nums[0];
        let n = nums.len();
        for i in 1..n {
            mx_num = mx_num.max(nums[i]);
        }
        let mut res = 0;
        for i in 0..n {
            res += (mx_num - nums[i])
        }
        res
    }
}

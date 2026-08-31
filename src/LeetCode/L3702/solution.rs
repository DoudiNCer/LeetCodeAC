use super::Solution;

/*
    给你一个整数数组 nums。

    返回 nums 中 按位异或（XOR）计算结果 非零 的 最长子序列 的长度。如果不存在这样的 子序列 ，返回 0 。

    子序列 是一个 非空 数组，可以通过从原数组中删除一些或不删除任何元素（不改变剩余元素的顺序）派生而来。

    提示：

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 10^9
*/

impl Solution {
    pub fn longest_subsequence(nums: Vec<i32>) -> i32 {
        let mut xor_cnt = 0;
        let mut xor_sum = 0;
        let n = nums.len();
        for num in nums {
            if num == 0 {
                continue;
            }
            xor_sum ^= num;
            xor_cnt += 1;
        }
        if xor_cnt == 0 {
            // all num is 0, return 0
            0
        } else if xor_sum != 0 {
            // the sum of non 0 num is 0, delete one of them
            n as i32
        } else {
            // remove one of non-0 num
            (n - 1) as i32
        }
    }
}

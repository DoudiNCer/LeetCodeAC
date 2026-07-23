use super::Solution;

/*
    给你一个长度为 n 的整数数组 nums，其中 nums 是范围 [1, n] 内所有数的 排列 。

    XOR 三元组 定义为三个元素的异或值 nums[i] XOR nums[j] XOR nums[k]，其中 i <= j <= k。

    返回所有可能三元组 (i, j, k) 中 不同 的 XOR 值的数量。

    排列 是一个集合中所有元素的重新排列。

    提示：

    1 <= n == nums.length <= 10^5
    1 <= nums[i] <= n
    nums 是从 1 到 n 的整数的一个排列。
*/

impl Solution {
    pub fn unique_xor_triplets(nums: Vec<i32>) -> i32 {
        let mut n = nums.len();
        if n < 3 {
            return n as i32;
        }
        let mut res = 1;
        while n > 0 {
            n >>= 1;
            res <<= 1;
        }
        res
    }
}

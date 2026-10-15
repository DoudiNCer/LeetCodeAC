use super::Solution;

/*
    给你一个下标从 0 开始的整数数组 nums 。

    定义 nums 一个子数组的 不同计数 值如下：

    令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ），那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。
    请你返回 nums 中所有子数组的 不同计数 的 平方 和。

    子数组指的是一个数组里面一段连续 非空 的元素序列。

    提示：

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
*/

impl Solution {
    pub fn sum_counts(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut res = 0;
        let mut cnt = 0;
        let mut cnts = vec![0; 101];
        for i in 0..n {
            for j in i..n {
                if cnts[nums[j] as usize] == 0 {
                    cnt += 1;
                }
                cnts[nums[j] as usize] += 1;
                res += cnt * cnt;
            }
            cnts = vec![0; 101];
            cnt = 0;
        }
        res
    }
}

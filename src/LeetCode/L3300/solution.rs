use super::Solution;

/*
    给你一个整数数组 nums 。

    请你将 nums 中每一个元素都替换为它的各个数位之 和 。

    请你返回替换所有元素以后 nums 中的 最小 元素。

    提示：

    1 <= nums.length <= 100
    1 <= nums[i] <= 10^4
*/

impl Solution {
    pub fn min_element(nums: Vec<i32>) -> i32 {
        let mut res = nums[0];
        for num in nums {
            let mut num = num;
            let mut sum = 0;
            while num > 0 {
                sum += num % 10;
                num /= 10;
            }
            res = res.min(sum)
        }
        res
    }
}
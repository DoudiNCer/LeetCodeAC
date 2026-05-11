use super::Solution;

/*
    给你一个正整数数组 nums ，请你返回一个数组 answer ，你需要将 nums 中每个整数进行数位分割后，按照 nums 中出现的 相同顺序 放入答案数组中。

    对一个整数进行数位分割，指的是将整数各个数位按原本出现的顺序排列成数组。

    比方说，整数 10921 ，分割它的各个数位得到 [1,0,9,2,1] 。

     提示：

    1 <= nums.length <= 1000
    1 <= nums[i] <= 10^5
*/

impl Solution {
    pub fn separate_digits(nums: Vec<i32>) -> Vec<i32> {
        let mut result = vec![];
        for num in nums {
            let mut i = result.len();
            let mut num = num;
            while num > 0 {
                result.push(num % 10);
                num /= 10;
            }
            let mut j = result.len() - 1;
            while i < j {
                (result[i], result[j]) = (result[j], result[i]);
                i += 1;
                j -= 1;
            }
        }
        result
    }
}

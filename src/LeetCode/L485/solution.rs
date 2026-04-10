use super::Solution;


/*
    给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。

    提示：

    1 <= nums.length <= 10^5
    nums[i] 不是 0 就是 1.
*/

impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        let mut result = 0i32;
        let mut cnt = 0i32;
        for x in nums {
            if x == 1 {
                cnt += 1;
            } else {
                if result < cnt {
                    result = cnt
                }
                cnt = 0
            }
        }
        if result < cnt {
            return cnt
        }
        result
    }
}
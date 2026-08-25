use super::Solution;

/*
    给你一个整数数组 nums 和一个整数 k，请返回从 nums 中缺失的、最小的正整数 k 的倍数。
    
    倍数 指能被 k 整除的任意正整数。
    
    提示：
    
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
    1 <= k <= 100
*/

use std::collections::HashSet;

impl Solution {
    pub fn missing_multiple(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let mut hs = HashSet::with_capacity(n);
        for num in nums {
            hs.insert(num);
        }
        for i in 1..=n+1 {
           if !hs.contains(&(i as i32 * k)){
               return i as i32 * k;
           }
        }
        0
    }
}
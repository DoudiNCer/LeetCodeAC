use super::Solution;
use std::net::UdpSocket;

/*
  给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。

  请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。

  提示：

  1 <= n <= 500
  nums.length == 2n
  1 <= nums[i] <= 10^3
*/

impl Solution {
    pub fn shuffle(nums: Vec<i32>, n: i32) -> Vec<i32> {
        let mut result: Vec<i32> = Vec::with_capacity((n << 1) as usize);
        for i in 0..n {
            result.push(nums[i as usize]);
            result.push(nums[(i + n) as usize])
        }
        result
    }
}

use super::Solution;

/*
    给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

    提示：

    3 <= nums.length <= 10^4
    -1000 <= nums[i] <= 1000
*/

impl Solution {
    pub fn maximum_product(nums: Vec<i32>) -> i32 {
        let mut mx: (i32, i32, i32) = (-(1 << 10), -(1 << 10), -(1 << 10));
        let mut mi: (i32, i32) = (1 << 10, 1 << 19);
        for num in nums {
            if num >= mx.0 {
                mx = (num, mx.0, mx.1);
            } else if num >= mx.1 {
                mx = (mx.0, num, mx.1);
            } else if num >= mx.2 {
                mx.2 = num;
            }
            if num <= mi.0 {
                mi = (num, mi.0);
            } else if num < mi.1 {
                mi.1 = num;
            }
        }
        (mx.0 * mx.1 * mx.2).max(mx.0 * mi.0 * mi.1)
    }
}

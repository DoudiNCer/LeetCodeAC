use super::Solution;
use std::f32::MAX_10_EXP;

/*
    给你两个 非递增 的整数数组 nums1​​​​​​ 和 nums2​​​​​​ ，数组下标均 从 0 开始 计数。

    下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i​​ 。​​

    返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。

    一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。

    提示:

    1 <= nums1.length <= 10^5
    1 <= nums2.length <= 10^5
    1 <= nums1[i], nums2[j] <= 10^5
    nums1 和 nums2 都是 非递增 数组
*/

impl Solution {
    pub fn max_distance(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        let mut res = 0;
        let mut j = (nums2.len() - 1) as i32;
        for (i, x) in nums1.iter().enumerate().rev() {
            let ii = i as i32;
            while j >= 0 && ii <= j && x > &nums2[j as usize] {
                j -= 1;
            }
            if j < 0 {
                break;
            }
            if ii <= j {
                res = res.max((j - ii))
            }
        }
        res
    }
}

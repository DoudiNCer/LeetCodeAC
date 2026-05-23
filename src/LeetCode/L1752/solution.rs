use super::Solution;

/*
    给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。

    如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。

    源数组中可能存在 重复项 。

    注意：数组 A 在轮转 x 个位置后得到长度相同的数组 B ，使得对于每一个有效的下标 i，满足 B[i] == A[(i+x) % A.length]。

    提示：

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
*/

impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        let n = nums.len();
        let mut pcnt = 0;
        for i in 0..n - 1 {
            if nums[i] > nums[i + 1] {
                pcnt += 1;
                if pcnt > 1 {
                    return false;
                }
            }
        }
        pcnt == 0 || nums[n - 1] <= nums[0]
    }
}

use super::Solution;

/*
    给你一个长度为 n 的数组 nums1，其中包含 互不相同 的整数。

    你需要构造另一个长度为 n 的数组 nums2，使得 nums2 中的元素要么全部为 奇数，要么全部为 偶数。

    对于每个下标 i，你必须从以下两种选择中 任选其一（顺序不限）：

    nums2[i] = nums1[i]
    nums2[i] = nums1[i] - nums1[j]，其中 j != i
    如果能够构造出满足条件的数组，则返回 true；否则，返回 false。

    提示：

    1 <= n == nums1.length <= 100
    1 <= nums1[i] <= 100
    nums1 中的所有整数互不相同。
*/

impl Solution {
    pub fn uniform_array(nums1: Vec<i32>) -> bool {
        // Return true for all even numbers
        // For inputs with at least one odd number, all even numbers can be converted to odd
        true
    }
}

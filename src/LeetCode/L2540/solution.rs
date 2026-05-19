use super::Solution;

/*
    给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。

    如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。

    提示：

    1 <= nums1.length, nums2.length <= 10^5
    1 <= nums1[i], nums2[j] <= 10^9
    nums1 和 nums2 都是 非降序 的。
*/

impl Solution {
    pub fn get_common(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        let (n1, n2) = (nums1.len(), nums2.len());
        let (mut i, mut j) = (0, 0);
        while i < n1 || j < n2 {
            if nums1[i] == nums2[j] {
                return nums1[i];
            }
            while i < n1 && nums1[i] < nums2[j] {
                i += 1;
            }
            if i >= n1 {
                break;
            }
            if nums1[i] == nums2[j] {
                return nums1[i];
            }
            while j < n2 && nums1[i] > nums2[j] {
                j += 1;
            }
            if j >= n2 {
                break;
            }
            if nums1[i] == nums2[j] {
                return nums1[i];
            }
        }
        -1
    }
}

package LeetCode.L2540;

/**
 * 给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。
 *
 * 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3], nums2 = [2,4]
 * 输出：2
 * 解释：两个数组的最小公共元素是 2 ，所以我们返回 2 。
 * 示例 2：
 *
 * 输入：nums1 = [1,2,3,6], nums2 = [2,3,4,5]
 * 输出：2
 * 解释：两个数组中的公共元素是 2 和 3 ，2 是较小值，所以返回 2 。
 *
 *
 * 提示：
 *
 * - 1 <= nums1.length, nums2.length <= 10^5
 * - 1 <= nums1[i], nums2[j] <= 10^9
 * - nums1 和 nums2 都是 非降序 的。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.getCommon(new int[]{1, 2, 3}, new int[]{2, 4}) = " + s.getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));
    }
}

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] == nums2[p2]){
                return nums1[p1];
            }
            if (nums1[p1] < nums2[p2]){
                p1++;
            } else {
                p2++;
            }
        }
        return -1;
    }
}
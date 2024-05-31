package LeetCode.L2605;

/**
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * 示例 2：
 *
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 *
 *
 * 提示：
 *
 * - 1 <= nums1.length, nums2.length <= 9
 * - 1 <= nums1[i], nums2[i] <= 9
 * - 每个数组中，元素 互不相同 。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.minNumber(new int[]{4, 1, 3}, new int[]{5, 7}) = " + s.minNumber(new int[]{4, 1, 3}, new int[]{5, 7}));
    }
}

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] status = new int[10];
        int min1 = nums1[0], min2 = nums2[0], min3 = 10;
        for (int i : nums1) {
            status[i] += 1;
            if (i < min1){
                min1 = i;
            }
            if (status[i] == 2 && i < min3){
                min3 = i;
            }
        }
        for (int i : nums2) {
            status[i] += 1;
            if (i < min2){
                min2 = i;
            }
            if (status[i] == 2 && i < min3){
                min3 = i;
            }
        }
        if (min3 < 10){
            return min3;
        } else if (min1 > min2){
            return min2 * 10 + min1;
        } else {
            return min1 * 10 + min2;
        }
    }
}
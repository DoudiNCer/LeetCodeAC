package LeetCode.L349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 *
 * 提示：
 *
 * - 1 <= nums1.length, nums2.length <= 1000
 * - 0 <= nums1[i], nums2[i] <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}) = " + Arrays.toString(s.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> rel = new HashSet<>();
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length){
            if (nums1[p1] == nums2[p2]){
                rel.add(nums1[p1]);
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]){
                p1++;
            } else {
                p2++;
            }
        }
        int[] result = new int[rel.size()];
        {
            int i = 0;
            for (Integer integer : rel) {
                result[i] = integer;
                i++;
            }
        }
        return result;
    }
}
package LeetCode.L3002;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们的长度都是偶数 n 。
 *
 * 你必须从 nums1 中移除 n / 2 个元素，同时从 nums2 中也移除 n / 2 个元素。移除之后，你将 nums1 和 nums2 中剩下的元素插入到集合 s 中。
 *
 * 返回集合 s可能的 最多 包含多少元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,1,2], nums2 = [1,1,1,1]
 * 输出：2
 * 解释：从 nums1 和 nums2 中移除两个 1 。移除后，数组变为 nums1 = [2,2] 和 nums2 = [1,1] 。因此，s = {1,2} 。
 * 可以证明，在移除之后，集合 s 最多可以包含 2 个元素。
 * 示例 2：
 *
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [2,3,2,3,2,3]
 * 输出：5
 * 解释：从 nums1 中移除 2、3 和 6 ，同时从 nums2 中移除两个 3 和一个 2 。移除后，数组变为 nums1 = [1,4,5] 和 nums2 = [2,3,2] 。因此，s = {1,2,3,4,5} 。
 * 可以证明，在移除之后，集合 s 最多可以包含 5 个元素。
 * 示例 3：
 *
 * 输入：nums1 = [1,1,2,2,3,3], nums2 = [4,4,5,5,6,6]
 * 输出：6
 * 解释：从 nums1 中移除 1、2 和 3 ，同时从 nums2 中移除 4、5 和 6 。移除后，数组变为 nums1 = [1,2,3] 和 nums2 = [4,5,6] 。因此，s = {1,2,3,4,5,6} 。
 * 可以证明，在移除之后，集合 s 最多可以包含 6 个元素。
 *
 *
 * 提示：
 *
 * - n == nums1.length == nums2.length
 * - 1 <= n <= 2 * 10^4
 * - n是偶数。
 * - 1 <= nums1[i], nums2[i] <= 10^9
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.maximumSetSize(new int[]{1, 2, 1, 2}, new int[]{1, 1, 1, 1}) = " + s.maximumSetSize(new int[]{1, 2, 1, 2}, new int[]{1, 1, 1, 1}));
        System.out.println("s.maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}) = " + s.maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}));
        System.out.println("s.maximumSetSize(new int[]{1, 1, 2, 2, 3, 3}, new int[]{4, 4, 5, 5, 6, 6}) = " + s.maximumSetSize(new int[]{1, 1, 2, 2, 3, 3}, new int[]{4, 4, 5, 5, 6, 6}));
        System.out.println("s.maximumetSize(new int[]{8, 9}, new int[]{2, 3}) = " + s.maximumSetSize(new int[]{8, 9}, new int[]{2, 3}));
        System.out.println("s.maximumSetSize(new int[]{1, 2, 1, 7}, new int[]{1, 1, 1, 1}) = " + s.maximumSetSize(new int[]{1, 2, 1, 7}, new int[]{1, 1, 1, 1}));
        System.out.println("s.maximumSetSize(new int[]{2, 4, 1, 4}, new int[]{10, 2, 4, 10}) = " + s.maximumSetSize(new int[]{2, 4, 1, 4}, new int[]{10, 2, 4, 10}));
        System.out.println("s.maximumSetSize(new int[]{9, 8, 8, 8, 2, 6, 4, 3}, new int[]{8, 10, 7, 8, 1, 9, 3, 8}) = " + s.maximumSetSize(new int[]{9, 8, 8, 8, 2, 6, 4, 3}, new int[]{8, 10, 7, 8, 1, 9, 3, 8}));
    }
}

class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int len = nums1.length;
        HashSet<Integer> n1c = new HashSet<>(len);
        HashSet<Integer> n2c = new HashSet<>(len);
        for (int i : nums1) {
            n1c.add(i);
        }
        for (int i : nums2) {
            n2c.add(i);
        }
        // n1 要删除的元素
        int x1 = n1c.size() - len / 2;
        if (x1 < 0){
            x1 = 0;
        }
        // n2 要删除的元素
        int x2 = n2c.size() - len / 2;
        if (x2 < 0){
            x2 = 0;
        }
        Set<Integer> ks = new HashSet<>(n1c);
        ks.retainAll(new HashSet<>(n2c));
        // n1，n2 重复元素
        int scnt = ks.size();
        int result = n1c.size() + n2c.size()  - scnt;
        if (scnt <= x1 && scnt <= x2){
            result -= (x1 + x2 - scnt);
        } else if (scnt > x1 && scnt > x2){
            if (x1 + x2 > scnt){
                result -= (x1 + x2 - scnt);
            }
        } else if (x1 >= scnt){
            result -= (x1 - scnt + x2);
        } else {
            result -= (x2 - scnt + x1);
        }
        return result;
    }
}
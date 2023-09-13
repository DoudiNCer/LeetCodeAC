package LeetCode.L4;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] n1 = {1, 3}, n2 = {2};
        System.out.println(s.findMedianSortedArrays(n1, n2));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = (nums1.length + nums2.length) / 2;
        int j = 0, k = 0;
        boolean x = false;
        int[] xp = new int[2];
        while((j + k) <= count){
            if (j >= nums1.length){
                xp[x ? 1 : 0] = nums2[k];
                x = !x;
                k++;
            } else if (k >= nums2.length){
                xp[x ? 1 : 0] = nums1[j];
                x = !x;
                j++;
            } else {
                if (nums1[j] < nums2[k]){
                    xp[x ? 1 : 0] = nums1[j];
                    x = !x;
                    j++;
                } else {
                    xp[x ? 1 : 0] = nums2[k];
                    x = !x;
                    k++;
                }
            }
        }
        if (((nums1.length + nums2.length) % 2) == 0){
            double result = xp[0] + xp[1];
            result = result / 2.0;
            return result;
        } else {
            return xp[x ? 0 : 1];
        }
    }
}

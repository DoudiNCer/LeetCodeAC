package LeetCode.L33;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.search(new int[]{4,5,6,7,0,1,2}, 0) = " + s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("s.search(new int[]{4,5,6,7,0,1,2}, 3) = " + s.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println("s.search(new int[]{1}, 0) = " + s.search(new int[]{1}, 0));
        System.out.println("s.search(new int[]{1, 3}, 3) = " + s.search(new int[]{1, 3}, 3));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        // 只有一个元素时
        int length = nums.length;
        if (length == 1){
            return (nums[0] == target ? 0 : -1);
        }
        if (nums[0] > target && nums[length - 1] < target){
            return -1;
        }
        int l = 0, r = length - 1, m = -1;
        // 发生非首尾端点旋转，寻找旋转点，缩减二分范围
        if (nums[0] >  nums[length - 1]) {
            while (l <= r){
                m = l + (r - l) / 2;
                if (nums[m] > nums[length - 1] && nums[m + 1] < nums[0]){
                    break;
                }
                if (nums[m] > nums[length - 1]){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            if (nums[0] > target){
                l = m + 1;
                r = length - 1;
            } else {
                l = 0;
                r = m;
            }
        }
        if (nums[r] == target){
            return r;
        }
        if (nums[l] == target){
            return l;
        }
        while (l <= r){
            m = l + (r - l) / 2;
            if (nums[m] > target){
                r = m - 1;
            } else if (nums[m] < target){
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
package LeetCode.L34;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.searchRange(new int[]{5,7,7,8,8,10}, 8) = " + Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println("s.searchRange(new int[]{}, 0) = " + Arrays.toString(s.searchRange(new int[]{}, 0)));
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1, -1};
        }
        if (nums.length == 1){
            if (nums[0] == target){
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        int l = 0, r = nums.length - 1, m = -1;
        if (nums[l] == target){
            m = l;
        } else if (nums[r] == target){
            m = r;
        } else {
            while (l <= r){
                m = l + (r - l) / 2;
                if (nums[m] == target){
                    break;
                }
                if (nums[m] < target){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        if(nums[m] != target){
            return new int[]{-1, -1};
        }
        l = r = m;
        while (l > 0 && nums[l - 1] == target){
            l--;
        }
        while (r < nums.length - 1 && nums[r + 1] == target){
            r++;
        }
        int[] result = new int[2];
        result[0] = l;
        result[1] = r;
        return result;
    }
}
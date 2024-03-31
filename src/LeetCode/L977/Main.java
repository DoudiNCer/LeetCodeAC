package LeetCode.L977;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 10^4
 * - -10^4 <= nums[i] <= 10^4
 * - nums 已按 非递减顺序 排序
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.sortedSquares(new int[]{-4, -1, 0, 3, 10}) = " + Arrays.toString(s.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        if (nums[0] < 0 && nums[nums.length - 1] > 0){
            int i = 0;
            while (!(nums[i] < 0 && nums[i + 1] >= 0)){
                i++;
            }
            int j = i + 1;
            while (i >= 0 || j < nums.length){
                if (i >= 0 && j < nums.length){
                    if (-nums[i] <= nums[j]){
                        result[j - i - 1] = nums[i] * nums[i];
                        i--;
                    } else {
                        result[j - i - 1] = nums[j] * nums[j];
                        j++;
                    }
                } else {
                    if (i < 0){
                        result[j] = nums[j] * nums[j];
                        j++;
                    } else {
                        result[result.length - 1 - i] = nums[i] * nums[i];
                        i--;
                    }
                }
            }
        } else {
            if (nums[0] >= 0){
                for (int i = 0; i < nums.length; i++) {
                    result[i] = nums[i] * nums[i];
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    result[nums.length - 1 - i] = nums[i] * nums[i];
                }
            }
        }
        return result;
    }
}
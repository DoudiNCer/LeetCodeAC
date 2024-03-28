package LeetCode.L2958;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 *
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 *
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 *
 * 请你返回 nums 中 最长好 子数组的长度。
 *
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1,2,3,1,2], k = 2
 * 输出：6
 * 解释：最长好子数组是 [1,2,3,1,2,3] ，值 1 ，2 和 3 在子数组中的频率都没有超过 k = 2 。[2,3,1,2,3,1] 和 [3,1,2,3,1,2] 也是好子数组。
 * 最长好子数组的长度为 6 。
 * 示例 2：
 *
 * 输入：nums = [1,2,1,2,1,2,1,2], k = 1
 * 输出：2
 * 解释：最长好子数组是 [1,2] ，值 1 和 2 在子数组中的频率都没有超过 k = 1 。[2,1] 也是好子数组。
 * 最长好子数组的长度为 2 。
 * 示例 3：
 *
 * 输入：nums = [5,5,5,5,5,5,5], k = 4
 * 输出：4
 * 解释：最长好子数组是 [5,5,5,5] ，值 5 在子数组中的频率没有超过 k = 4 。
 * 最长好子数组的长度为 4 。
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^9
 * - 1 <= k <= nums.length
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.maxSubarrayLength(new int[]{1,2,3,1,2,3,1,2}, 2) = " + s.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
    }
}

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int l = 0;
        int result = 0;
        for(int r = 0; r < nums.length; r++){
            Integer f = frequencies.get(nums[r]);
            if (f == null){
                f = 1;
            } else {
                f++;
            }
            frequencies.put(nums[r], f);
            if (f > k){
                while (nums[l] != nums[r]){
                    f = frequencies.get(nums[l]);
                    if (f == 1){
                        frequencies.remove(nums[l]);
                    } else {
                        frequencies.put(nums[l], f - 1);
                    }
                    l++;
                }
                l++;
                frequencies.put(nums[r], frequencies.get(nums[r]) - 1);
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}

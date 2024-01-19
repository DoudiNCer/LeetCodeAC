package LeetCode.L217;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.containsDuplicate(new int[]{1, 2, 3, 1}) = " + s.containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> keys = new HashSet<>();
        for (int num : nums) {
            if (!keys.add(num)){
                return true;
            }
        }
        return false;
    }
}
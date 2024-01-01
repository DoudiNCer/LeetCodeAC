package LeetCode.L41;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5 * 10^5
 * -231 <= nums[i] <= 2^31 - 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.firstMissingPositive(new int[]{1, 2, 0}) = " + s.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println("s.firstMissingPositive(new int[]{3,4,-1,1}) = " + s.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println("s.firstMissingPositive(new int[]{7,8,9,11,12}) = " + s.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 1;
        while (set.contains(result)){
            result++;
        }
        return result;
    }
}
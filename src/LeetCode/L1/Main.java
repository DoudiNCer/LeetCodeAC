package LeetCode.L1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println("s.twoSum(nums, target) = " + Arrays.toString(s.twoSum(nums, target)));
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> nm = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            nm.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++){
            if (nm.get(target - nums[i]) != null && i != nm.get(target - nums[i]))
                return new int[]{i, nm.get(target - nums[i])};
        }
        return null;
    }
}

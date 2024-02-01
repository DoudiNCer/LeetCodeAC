package LeetCode.L2870;

import java.util.HashMap;

/**
 * 给你一个下标从 0 开始的正整数数组 nums 。
 *
 * 你可以对数组执行以下两种操作 任意次 ：
 *
 * 从数组中选择 两个 值 相等 的元素，并将它们从数组中 删除 。
 * 从数组中选择 三个 值 相等 的元素，并将它们从数组中 删除 。
 * 请你返回使数组为空的 最少 操作次数，如果无法达成，请返回 -1 。
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.minOperations(new int[]{2,3,3,2,2,4,2,3,4}) = " + s.minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        System.out.println("s.minOperations(new int[]{19,19,19,19,19,19,19,19,19,19,19,19,19}) = " + s.minOperations(new int[]{19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19}));
    }
}

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> cnt = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            Integer i = cnt.get(num);
            cnt.put(num, (i == null) ? 1 : i + 1);
        }
        for (Integer v : cnt.values()) {
            int tres = (v / 6) * 2;
            switch (v % 6){
                case 0:
                    break;
                case 1:
                    if (tres < 2){
                        return -1;
                    }
                case 2:
                case 3:
                    tres += 1;
                    break;
                default:
                    tres += 2;
                    break;
            }
            result += tres;
        }
        return result;
    }
}
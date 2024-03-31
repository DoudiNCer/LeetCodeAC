package LeetCode.L442;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[]
 *
 *
 * 提示：
 *
 * - n == nums.length
 * - 1 <= n <= 10^5
 * - 1 <= nums[i] <= n
 * - nums 中的每个元素出现 一次 或 两次
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}) = " + s.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int p = num > 0 ? num : -num;
            if (nums[p - 1] < 0){
                result.add(p);
            } else {
                nums[p - 1] = -nums[p - 1];
            }
        }
        return result;
    }
}
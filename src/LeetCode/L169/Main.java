package LeetCode.L169;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 *
 * 提示：
 * - n == nums.length
 * - 1 <= n <= 5 * 10^4
 * - -10^9 <= nums[i] <= 10^9
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.majorityElement(new int[]{3, 2, 3}) = " + s.majorityElement(new int[]{3, 2, 3}));
        System.out.println("s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}) = " + s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println("s.majorityElement(new int[]{1}) = " + s.majorityElement(new int[]{1}));
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int num : nums) {
            Integer cnt = cnts.get(num);
            if (cnt == null){
                cnt = 1;
            } else {
                cnt++;
                if (cnt > nums.length / 2){
                    return num;
                }
            }
            cnts.put(num, cnt);
        }
        return 0;
    }
}
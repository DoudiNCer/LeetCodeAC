package LeetCode.L229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 5 * 10^4
 * - -10^9 <= nums[i] <= 10^9
 *
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.majorityElement(new int[]{3, 2, 3}) = " + s.majorityElement(new int[]{3, 2, 3}));
        System.out.println("s.majorityElement(new int[]{1}) = " + s.majorityElement(new int[]{1}));
        System.out.println("s.majorityElement(new int[]{1, 2}) = " + s.majorityElement(new int[]{1, 2}));
    }
}

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> cnts = new HashMap<>();
        List<Integer> result = new ArrayList<>(2);
        int threshold = nums.length / 3;
        for (int num : nums) {
            Integer cnt = cnts.get(num);
            if (cnt == null) {
                cnt = 1;
            } else {
                cnt++;
            }
            cnts.put(num, cnt);
            if (cnt == threshold + 1) {
                result.add(num);
            }
            if (cnt > (nums.length - threshold) || result.size() == 2) {
                return result;
            }
        }
        return result;
    }
}
package LeetCode.L1814;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 *
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 *  - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 *  - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * 示例 2：
 *
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 10^5
 * - 0 <= nums[i] <= 109
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.countNicePairs(new int[]{42, 11, 1, 97}) = " + s.countNicePairs(new int[]{42, 11, 1, 97}));
        System.out.println("s.countNicePairs(new int[]{13, 10, 35, 24, 76}) = " + s.countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }
}

class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int num : nums) {
            int rd = revDiff(num);
            Integer cnt = cnts.get(rd);
            if (cnt == null){
                cnt = 1;
            } else {

                cnt++;
            }
            cnts.put(rd, cnt);
        }
        long result = 0;
        for (Integer value : cnts.values()) {
            result += (long) value * (value - 1) / 2;
        }
        return (int) (result % 1000000007);
    }
    private int revDiff(int x){
        int rev = 0, res = x;
        while (x > 0){
            rev *= 10;
            rev += x % 10;
            x /= 10;
        }
        return res - rev;
    }
}
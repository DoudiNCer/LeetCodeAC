package LeetCode.L896;

/**
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 *
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> = nums[j]，那么数组 nums 是单调递减的。
 *
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,3,2]
 * 输出：false
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 10^5
 * - -10^5 <= nums[i] <= 10^5
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isMonotonic(new int[]{1, 2, 2, 3}) = " + s.isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println("s.isMonotonic(new int[]{6, 5, 4, 4}) = " + s.isMonotonic(new int[]{6, 5, 4, 4}));
        System.out.println("s.isMonotonic(new int[]{1, 3, 2}) = " + s.isMonotonic(new int[]{1, 3, 2}));
    }
}

class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean mi = true, md = true;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i - 1]){
                md = false;
            } else if (nums[i] < nums[i - 1]) {
                mi = false;
            }
        }
        return md || mi;
    }
}
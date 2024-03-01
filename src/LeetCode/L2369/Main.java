package LeetCode.L2369;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
 *
 * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
 *
 * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
 * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
 * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
 * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,4,4,5,6]
 * 输出：true
 * 解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
 * 这是一种有效划分，所以返回 true 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,2]
 * 输出：false
 * 解释：该数组不存在有效划分。
 *
 *
 * 提示：
 *
 * - 2 <= nums.length <= 10^5
 * - 1 <= nums[i] <= 10^6
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.validPartition(new int[]{4, 4, 4, 5, 6}) = " + s.validPartition(new int[]{4, 4, 4, 5, 6}));
    }
}

class Solution {
    private int[] nums;

    public boolean validPartition(int[] nums) {
        this.nums = nums;
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        for (int i = 0; i <= nums.length; i++){
            if (i > 1){
                dp[i] = dp[i - 2] && checkTwo(i - 2);
            }
            if (i > 2){
                dp[i] = dp[i] || dp[i - 3] && checkThree(i - 3);
            }
        }
        return dp[nums.length];
    }

    private boolean checkTwo(int start){
        return nums[start] == nums[start + 1];
    }

    private boolean checkThree(int start){
        return (nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2]) || (nums[start] + 1 == nums[start + 1] && nums[start + 1] + 1 == nums[start + 2]);
    }
}

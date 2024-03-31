package LeetCode.W391.L2;

/**
 * 100266. 交替子数组计数 显示英文描述
 * 通过的用户数74
 * 尝试过的用户数79
 * 用户总通过次数74
 * 用户总提交次数83
 * 题目难度Medium
 * 给你一个二进制数组 nums 。
 *
 * 如果一个子数组中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。
 *
 * 返回数组 nums 中交替子数组的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入： nums = [0,1,1,1]
 *
 * 输出： 5
 *
 * 解释：
 *
 * 以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。
 *
 * 示例 2：
 *
 * 输入： nums = [1,0,1,0]
 *
 * 输出： 10
 *
 * 解释：
 *
 * 数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。
 *
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 10^5
 * - nums[i] 不是 0 就是 1 。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.countAlternatingSubarrays(new int[]{1, 0, 1, 1, 1, 1, 0, 1, 0, 0}) = " + s.countAlternatingSubarrays(new int[]{1, 0, 1, 1, 1, 1, 0, 1, 0, 0}));
    }
}

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long result = 0, lx = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] == nums[i]){
                result += lx * (lx + 1) / 2;
                lx = 1;
            } else {
                lx++;
            }
        }
        result += lx * (lx + 1) / 2;
        return result;
    }
}
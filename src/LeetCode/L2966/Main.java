package LeetCode.L2966;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。
 *
 * 将这个数组划分为一个或多个长度为 3 的子数组，并满足以下条件：
 *
 * nums 中的 每个 元素都必须 恰好 存在于某个子数组中。
 * 子数组中 任意 两个元素的差必须小于或等于 k 。
 * 返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。如果有多个答案，返回 任意一个 即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,8,7,9,3,5,1], k = 2
 * 输出：[[1,1,3],[3,4,5],[7,8,9]]
 * 解释：可以将数组划分为以下子数组：[1,1,3]，[3,4,5] 和 [7,8,9] 。
 * 每个子数组中任意两个元素的差都小于或等于 2 。
 * 注意，元素的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [1,3,3,2,7,3], k = 3
 * 输出：[]
 * 解释：无法划分数组满足所有条件。
 *
 *
 * 提示：
 *
 * - n == nums.length
 * - 1 <= n <= 10^5
 * - n 是 3 的倍数
 * - 1 <= nums[i] <= 10^5
 * - 1 <= k <= 10^5
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2) = " + Arrays.deepToString(s.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)));
    }
}

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length / 3;
        int[][] result = new int[len][3];
        for (int i = 0; i < len; i++){
            if (nums[i * 3 + 2] - nums[i * 3] <= k){
                result[i][0] = nums[i * 3];
                result[i][1] = nums[i * 3 + 1];
                result[i][2] = nums[i * 3 + 2];
            } else {
                return new int[][]{};
            }
        }
        return result;
    }
}
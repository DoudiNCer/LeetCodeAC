package LeetCode.L368;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 *
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 *
 *
 * 提示：
 *
 * - 1 <= nums.length <= 1000
 * - 1 <= nums[i] <= 2 * 10^9
 * - nums 中的所有整数 互不相同
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.largestDivisibleSubset(new int[]{1, 2, 3}) = " + s.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println("s.largestDivisibleSubset(new int[]{1, 2, 4, 8}) = " + s.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[][] dp = new int[nums.length + 1][2];
        int ms = 0;
        for (int i = 1; i < nums.length; i++){
            boolean ok = false;
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] != 0){
                    continue;
                }
                ok = true;
                if (dp[j + 1][1] >= dp[dp[i + 1][0]][1]){
                    dp[i + 1][0] = j + 1;
                }
            }
            if (ok){
                dp[i + 1][1] = dp[dp[i + 1][0]][1] + 1;
            }
            if (dp[ms][1] < dp[i + 1][1]){
                ms = i + 1;
            }
        }
        System.out.println("dp = " + Arrays.deepToString(dp));
        List<Integer> result = new LinkedList<>();
        if (ms == 0){
            result.add(nums[0]);
        }
        while (ms > 0){
            result.add(nums[ms - 1]);
            ms = dp[ms][0];
        }
        return result;
    }
}
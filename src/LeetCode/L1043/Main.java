package LeetCode.L1043;

/**
 * 给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 *
 * 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * 输出：84
 * 解释：数组变为 [15,15,15,9,10,10,10]
 * 示例 2：
 *
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * 输出：83
 * 示例 3：
 *
 * 输入：arr = [1], k = 1
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^9
 * 1 <= k <= arr.length
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3) = " + s.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int max = 0;
        if (arr.length <= k){
            for (int i : arr) {
                max = Math.max(i, max);
            }
            return max * arr.length;
        }
        int[] dp = new int[arr.length];
        for (int i = 0; i < k; i++){
            max = Math.max(max, arr[i]);
            dp[i] = max * (i + 1);
        }
        for (int i = k; i < arr.length; i++){
            max = 0;
            int maxc = 0;
            for (int j = 0; j < k; j++){
                maxc = Math.max(maxc, arr[i - j]);
                max = Math.max(max, dp[i - j - 1] + maxc * (j + 1));
            }
            dp[i] = max;
        }
        return dp[arr.length - 1];
    }
}

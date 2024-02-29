package LeetCode.L338;

import java.util.Arrays;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * 提示：
 *
 * - 0 <= n <= 10^5
 *
 *
 * 进阶：
 *
 * - 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * - 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.countBits(2) = " + Arrays.toString(s.countBits(2)));
        System.out.println("s.countBits(5) = " + Arrays.toString(s.countBits(5)));
        System.out.println("s.countBits(50) = " + Arrays.toString(s.countBits(50)));
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int i = 0, k = 0;
        while (i < n){
            int px = 1 << k;
            int end = Math.min(n, i + (1 << k));
            while (i < end){
                i++;
                dp[i] = dp[i - px] + 1;
            }
            k++;
        }
        return dp;
    }
}
package LeetCode.L50;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * 提示：
 *
 * - -100.0 < x < 100.0
 * - -2^31 <= n <= 2^31-1
 * - n 是一个整数
 * - 要么 x 不为零，要么 n > 0 。
 * - -10^4 <= xn <= 10^4
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.myPow(2.0, 10) = " + s.myPow(2.0, 10));
    }
}

class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}
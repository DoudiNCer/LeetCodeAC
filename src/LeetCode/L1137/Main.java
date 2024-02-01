package LeetCode.L1137;

/**
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 *
 *
 * 提示：
 *
 * - 0 <= n <= 37
 * - 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.tribonacci(2) = " + s.tribonacci(2));
        System.out.println("s.tribonacci(3) = " + s.tribonacci(3));
        System.out.println("s.tribonacci(4) = " + s.tribonacci(4));
        System.out.println("s.tribonacci(25) = " + s.tribonacci(25));
    }
}
class Solution {
    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        } else if (n == 2){
            return 1;
        }
        int x = 0, y = 1, z = 1;
        while (n > 2){
            int t = x + y + z;
            x = y;
            y = z;
            z = t;
            n--;
        }
        return z;
    }
}
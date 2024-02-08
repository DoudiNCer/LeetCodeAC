package LeetCode.L343;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: n = 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 *
 * 提示:
 *
 * - 2 <= n <= 58
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.integerBreak(2) = " + s.integerBreak(2));
        System.out.println("s.integerBreak(9) = " + s.integerBreak(9));
        System.out.println("s.integerBreak(10) = " + s.integerBreak(10));
    }
}

class Solution {
    public int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int result = 1;
        while (n > 4) {
            n -= 3;
            result *= 3;
        }
        result *= n;
        return result;
    }
}
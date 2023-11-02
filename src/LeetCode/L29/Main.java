package LeetCode.L29;

/**
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 *
 * 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的 商 。
 *
 * 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2^31,  2^31 − 1] 。本题中，如果商 严格大于 2^31 − 1 ，则返回 2^31 − 1 ；如果商 严格小于 -2^31 ，则返回 -2^31 。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(10, 3));
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        // 被除数为0
        if (dividend == 0){
            return 0;
        }
        // 除数为1
        if (divisor == 1){
            return dividend;
        }
        // 除数为-1
        if (divisor == -1){
            // 被除数为-2e31,结果发生正溢出
            if (dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        // 商的符号是否为负
        boolean negative = false;
        if (dividend > 0){
            dividend = - dividend;
            negative = true;
        }
        if (divisor > 0){
            divisor = - divisor;
            negative = !negative;
        }
        int result = 0;
        do {
            dividend -= divisor;
            result--;
        } while (dividend < 0);
        if (dividend > 0){
            result++;
        }
        if (!negative){
            result = -result;
        }
        return result;
    }
}
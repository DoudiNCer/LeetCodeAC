package LeetCode.L69;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 *
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 *
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.mySqrt(0) = " + s.mySqrt(0));
        System.out.println("s.mySqrt(1) = " + s.mySqrt(1));
        System.out.println("s.mySqrt(5) = " + s.mySqrt(5));
        System.out.println("s.mySqrt(1024) = " + s.mySqrt(1024));
        System.out.println("s.mySqrt(2147395600) = " + s.mySqrt(2147395600));
    }
}

class Solution {
    public int mySqrt(int x) {
        if (x >= 2147395600){
            return 46340;
        }
        int result = 0;
        while ((result + 1) * (result + 1) <= x){
            result++;
        }
        return result;
    }
}
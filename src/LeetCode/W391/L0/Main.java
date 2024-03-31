package LeetCode.W391.L0;

/**
 * 100263. 哈沙德数 显示英文描述
 * 通过的用户数0
 * 尝试过的用户数0
 * 用户总通过次数0
 * 用户总提交次数0
 * 题目难度Easy
 * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入： x = 18
 *
 * 输出： 9
 *
 * 解释：
 *
 * x 各个数位上的数字之和为 9 。18 能被 9 整除。因此 18 是哈沙德数，答案是 9 。
 *
 * 示例 2：
 *
 * 输入： x = 23
 *
 * 输出： -1
 *
 * 解释：
 *
 * x 各个数位上的数字之和为 5 。23 不能被 5 整除。因此 23 不是哈沙德数，答案是 -1 。
 *
 *
 *
 * 提示：
 *
 * 1 <= x <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.sumOfTheDigitsOfHarshadNumber(18) = " + s.sumOfTheDigitsOfHarshadNumber(18));
    }
}

class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int result = 0, lx = x;
        while (lx > 0){
            result += lx % 10;
            lx /= 10;
        }
        int ly = x / result;
        if (ly * result == x){
            return result;
        } else {
            return -1;
        }
    }
}
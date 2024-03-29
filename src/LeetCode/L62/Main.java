package LeetCode.L62;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 * 示例 1：
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 *
 * 提示：
 *
 * - 1 <= m, n <= 100
 * - 题目数据保证答案小于等于 2 * 10^9
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.uniquePaths(3, 7) = " + s.uniquePaths(3, 7));
        System.out.println("s.uniquePaths(3, 2) = " + s.uniquePaths(3, 2));
        System.out.println("s.uniquePaths(7, 3) = " + s.uniquePaths(7, 3));
        System.out.println("s.uniquePaths(3, 3) = " + s.uniquePaths(3, 3));
        System.out.println("s.uniquePaths(9, 9) = " + s.uniquePaths(10, 10));
        System.out.println("s.uniquePaths(16, 16) = " + s.uniquePaths(16, 16));
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int cm = Math.min(m, n) - 1;
        long result = 1;
        int is = m + n - cm - 1, js = 1;
        for (int i = 0; i < cm; i++){
            result *= (is + i);
            result /= (js + i);
        }
        return (int) result;
    }
}
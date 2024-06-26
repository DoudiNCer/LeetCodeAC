package LeetCode.L2684;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 *
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 *
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 * 返回你在矩阵中能够 移动 的 最大 次数。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * 输出：3
 * 解释：可以从单元格 (0, 0) 开始并且按下面的路径移动：
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * 可以证明这是能够移动的最大次数。
 * 示例 2：
 *
 *
 * 输入：grid = [[3,2,4],[2,1,9],[1,1,7]]
 * 输出：0
 * 解释：从第一列的任一单元格开始都无法移动。
 *
 *
 * 提示：
 *
 * - m == grid.length
 * - n == grid[i].length
 * - 2 <= m, n <= 1000
 * - 4 <= m * n <= 10^5
 * - 1 <= grid[i][j] <= 10^6
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.maxMoves(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}) = " + s.maxMoves(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}));
    }
}

class Solution {
    public int maxMoves(int[][] grid) {
        int[][] dp = new int[2][grid.length];
        for (int j = grid[0].length - 2; j >= 0; j--){
            for (int i = 0; i < grid.length; i++){
                dp[1][i] = 0;
                if (i - 1 >= 0 && grid[i][j] < grid[i - 1][j + 1]){
                    dp[1][i] = Math.max(dp[1][i], dp[0][i - 1] + 1);
                }
                if (grid[i][j] < grid[i][j + 1]){
                    dp[1][i] = Math.max(dp[1][i], dp[0][i] + 1);
                }
                if (i + 1 < grid.length && grid[i][j] < grid[i + 1][j + 1]){
                    dp[1][i] = Math.max(dp[1][i], dp[0][i + 1] + 1);
                }
            }
            int[] tmp = dp[0];
            dp[0] = dp[1];
            dp[1] = tmp;
        }
        int max = dp[0][0];
        for (int i : dp[0]) {
            max = Math.max(max, i);
        }
        return max;
    }
}
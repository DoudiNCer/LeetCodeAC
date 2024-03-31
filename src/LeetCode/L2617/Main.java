package LeetCode.L2617;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。你一开始的位置在 左上角 格子 (0, 0) 。
 *
 * 当你在格子 (i, j) 的时候，你可以移动到以下格子之一：
 *
 * 满足 j < k <= grid[i][j] + j 的格子 (i, k) （向右移动），或者
 * 满足 i < k <= grid[i][j] + i 的格子 (k, j) （向下移动）。
 * 请你返回到达 右下角 格子 (m - 1, n - 1) 需要经过的最少移动格子数，如果无法到达右下角格子，请你返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]
 * 输出：4
 * 解释：上图展示了到达右下角格子经过的 4 个格子。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]
 * 输出：3
 * 解释：上图展示了到达右下角格子经过的 3 个格子。
 * 示例 3：
 *
 *
 *
 * 输入：grid = [[2,1,0],[1,0,0]]
 * 输出：-1
 * 解释：无法到达右下角格子。
 *
 *
 * 提示：
 *
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 10^5
 * - 1 <= m * n <= 10^5
 * - 0 <= grid[i][j] < m * n
 * - grid[m - 1][n - 1] == 0
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.minimumVisitedCells(new int[][]{{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}}) = " + s.minimumVisitedCells(new int[][]{{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}}));
        System.out.println("s.minimumVisitedCells(new int[][]{{7, 12, 11, 11, 4}, {10, 5, 16, 15, 7}, {7, 9, 6, 16, 7}, {1, 13, 3, 16, 0}}) = " + s.minimumVisitedCells(new int[][]{{7, 12, 11, 11, 4}, {10, 5, 16, 15, 7}, {7, 9, 6, 16, 7}, {1, 13, 3, 16, 0}}));
    }
}

class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], -1);
        }
        dist[0][0] = 1;
        PriorityQueue<int[]>[] row = new PriorityQueue[m];
        PriorityQueue<int[]>[] col = new PriorityQueue[n];
        for (int i = 0; i < m; ++i) {
            row[i] = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        }
        for (int i = 0; i < n; ++i) {
            col[i] = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                while (!row[i].isEmpty() && row[i].peek()[1] + grid[i][row[i].peek()[1]] < j) {
                    row[i].poll();
                }
                if (!row[i].isEmpty()) {
                    dist[i][j] = update(dist[i][j], dist[i][row[i].peek()[1]] + 1);
                }

                while (!col[j].isEmpty() && col[j].peek()[1] + grid[col[j].peek()[1]][j] < i) {
                    col[j].poll();
                }
                if (!col[j].isEmpty()) {
                    dist[i][j] = update(dist[i][j], dist[col[j].peek()[1]][j] + 1);
                }

                if (dist[i][j] != -1) {
                    row[i].offer(new int[]{dist[i][j], j});
                    col[j].offer(new int[]{dist[i][j], i});
                }
            }
        }
        return dist[m - 1][n - 1];
    }

    public int update(int x, int y) {
        return x == -1 || y < x ? y : x;
    }
}
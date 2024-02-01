package LeetCode.L695;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println("s.maxAreaOfIsland(grid) = " + s.maxAreaOfIsland(grid));
    }
}

class Solution {
    private int ml;
    private int nl;

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        ml = grid.length;
        nl = grid[0].length;
        for (int x = 0; x < ml; x++) {
            for (int y = 0; y < nl; y++) {
                result = Math.max(dfs(grid, x, y), result);
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x == ml || y == nl || grid[x][y] != 1) {
            return 0;
        }
        int res = 1;
        grid[x][y] = 0;
        res += dfs(grid, x + 1, y);
        res += dfs(grid, x - 1, y);
        res += dfs(grid, x, y + 1);
        res += dfs(grid, x, y - 1);
        return res;
    }
}
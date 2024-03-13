package LeetCode.L200;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 *
 * 提示：
 *
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 300
 * - grid[i][j] 的值为 '0' 或 '1'
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}) = " + s.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }
}

class Solution {
    private int m;
    private int n;
    private char[][] grid;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    remove(i, j);
                }
            }
        }
        return cnt;
    }

    private void remove(int x, int y) {
        if (x < 0 || x > m || y < 0 || y > n) {
            return;
        }
        grid[x][y] = 0;
        if (y > 0 && grid[x][y - 1] == '1') {
            remove(x, y - 1);
        }
        if (y + 1 < n && grid[x][y + 1] == '1') {
            remove(x, y + 1);
        }
        if (x > 0 && grid[x - 1][y] == '1') {
            remove(x - 1, y);
        }
        if (x + 1 < m && grid[x + 1][y] == '1') {
            remove(x + 1, y);
        }
    }
}
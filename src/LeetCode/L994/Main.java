package LeetCode.L994;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 *
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 *
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *
 *
 * 提示：
 *
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m, n <= 10
 * - grid[i][j] 仅为 0、1 或 2
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.orangesRotting(new int[][]{{0}}) = " + s.orangesRotting(new int[][]{{0}}));
        System.out.println("s.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}) = " + s.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] diff = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int result = 0;
        int good = 0;
        for (int[] g : grid) {
            for (int i : g) {
                if (i == 1){
                    good++;
                }
            }
        }
        if (good == 0){
            return 0;
        }
        boolean killed = true;
        while (good >= 0 && killed){
            killed = false;
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    if (grid[i][j] == 2){
                        for (int d = 0; d < 2; d++) {
                            int x = i + diff[d][0], y = j + diff[d][1];
                            if (x >= 0 && x < m && y >= 0 && y < n){
                                if (grid[x][y] == 1){
                                    grid[x][y] = 2;
                                    killed = true;
                                    good--;
                                }
                            }
                        }
                        for (int d = 2; d < 4; d++) {
                            int x = i + diff[d][0], y = j + diff[d][1];
                            if (x >= 0 && x < m && y >= 0 && y < n){
                                if (grid[x][y] == 1){
                                    grid[x][y] = 3;
                                    killed = true;
                                    good--;
                                }
                            }
                        }
                    } else if (grid[i][j] == 3){
                        grid[i][j] = 2;
                    }
                }
            }
            if (killed){
                result++;
            }
        }
        return good == 0 ? result : -1;
    }
}
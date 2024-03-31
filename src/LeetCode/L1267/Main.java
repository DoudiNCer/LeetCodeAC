package LeetCode.L1267;

/**
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 *
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 *
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * 示例 3：
 *
 *
 *
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 *
 *
 * 提示：
 *
 * - m == grid.length
 * - n == grid[i].length
 * - 1 <= m <= 250
 * - 1 <= n <= 250
 * - grid[i][j] == 0 or 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.countServers(new int[][]{{1, 0}, {0, 1}}) = " + s.countServers(new int[][]{{1, 0}, {0, 1}}));
        System.out.println("s.countServers(new int[][]{{1, 0}, {1, 1}}) = " + s.countServers(new int[][]{{1, 0}, {1, 1}}));
        System.out.println("s.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}) = " + s.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
    }
}

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] mc = new int[m], nc = new int[n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    cnt++;
                    if (mc[i] == 0) {
                        mc[i] = j + 1;
                    } else if (mc[i] > 0) {
                        mc[i] = -1;
                    }
                    if (nc[j] == 0) {
                        nc[j] = i + 1;
                    } else if (nc[j] > 0) {
                        nc[j] = -1;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (mc[i] > 0) {
                if (nc[mc[i] - 1] - 1 == i) {
                    result++;
                }
            }
        }
        return cnt - result;
    }
}
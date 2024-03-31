package LeetCode.L289;

import java.util.Arrays;

/**
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * 示例 2：
 *
 *
 * 输入：board = [[1,1],[1,0]]
 * 输出：[[1,1],[1,1]]
 *
 *
 * 提示：
 *
 * - m == board.length
 * - n == board[i].length
 * - 1 <= m, n <= 25
 * - board[i][j] 为 0 或 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        s.gameOfLife(board);
        System.out.println("board = " + Arrays.deepToString(board));
    }
}

class Solution {
    public void gameOfLife(int[][] board) {
        int[] X = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] Y = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int[][] result = new int[board.length][board[0].length];
        for (int x = 0; x < board.length; x++){
            for (int y = 0; y < board[0].length; y++){
                int cnt = 0;
                for (int i = 0; i < 8; i++){
                    int x1 = x + X[i], y1 = y + Y[i];
                    if (x1 < 0 || x1 >= board.length || y1 < 0 || y1 >= board[0].length){
                        continue;
                    }
                    cnt += board[x1][y1];
                }
                if ((board[x][y] == 1) && (cnt == 2 || cnt == 3) || board[x][y] == 0 && cnt == 3){
                    result[x][y] = 1;
                }
            }
        }
        for (int i = 0; i < board.length; i++){
            System.arraycopy(result[i], 0, board[i], 0, board[0].length);
        }
    }
}
package LeetCode.L79;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 *
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 *
 *
 * 提示：
 *
 * - m == board.length
 * - n = board[i].length
 * - 1 <= m, n <= 6
 * - 1 <= word.length <= 15
 * - board 和 word 仅由大小写英文字母组成
 *
 *
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, \"ABCCED\") = " + s.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}

class Solution {
    private char[][] board;
    private char[] target;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        target = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target[0]) {
                    char t = board[i][j];
                    board[i][j] = 0;
                    boolean result = scanAndCheck(i, j, 1);
                    board[i][j] = t;
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean scanAndCheck(int x, int y, int d) {
        if (d == target.length) {
            return true;
        }
        if (x > 0 && board[x - 1][y] == target[d]) {
            char t = board[x - 1][y];
            board[x - 1][y] = 0;
            boolean result = scanAndCheck(x - 1, y, d + 1);
            board[x - 1][y] = t;
            if (result) {
                return true;
            }
        }
        if (x + 1 < board.length && board[x + 1][y] == target[d]) {
            char t = board[x + 1][y];
            board[x + 1][y] = 0;
            boolean result = scanAndCheck(x + 1, y, d + 1);
            board[x + 1][y] = t;
            if (result) {
                return true;
            }
        }
        if (y > 0 && board[x][y - 1] == target[d]) {
            char t = board[x][y - 1];
            board[x][y - 1] = 0;
            boolean result = scanAndCheck(x, y - 1, d + 1);
            board[x][y - 1] = t;
            if (result) {
                return true;
            }
        }
        if (y + 1 < board[0].length && board[x][y + 1] == target[d]) {
            char t = board[x][y + 1];
            board[x][y + 1] = 0;
            boolean result = scanAndCheck(x, y + 1, d + 1);
            board[x][y + 1] = t;
            return result;
        }
        return false;
    }
}
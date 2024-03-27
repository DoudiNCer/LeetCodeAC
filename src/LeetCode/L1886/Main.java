package LeetCode.L1886;

/**
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * 示例 2：
 *
 *
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * 示例 3：
 *
 *
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 *
 *
 * 提示：
 *
 * - n == mat.length == target.length
 * - n == mat[i].length == target[i].length
 * - 1 <= n <= 10
 * - mat[i][j] 和 target[i][j] 不是 0 就是 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.findRotation(new int[][]{{1, 0}, {0, 1}}, new int[][]{{0, 1}, {1, 0}}) = " + s.findRotation(new int[][]{{1, 0}, {0, 1}}, new int[][]{{0, 1}, {1, 0}}));
    }
}

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int result = 15;
        int n = mat.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if ((result & 1) == 1 && mat[i][j] != target[j][n - 1 - i]){
                    result &= 14;
                }
                if ((result & 2) == 2 && mat[i][j] != target[n - i - 1][n - j - 1]  ){
                    result &= 13;
                }
                if ((result & 4) == 4 && mat[i][j] != target[n - 1 - j][i]){
                    result &= 11;
                }
                if ((result & 8) == 8 && mat[i][j] != target[i][j]){
                    result &= 7;
                }
                if (result == 0){
                    return false;
                }
            }
        }
        return true;
    }
}

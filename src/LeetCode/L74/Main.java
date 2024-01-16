package LeetCode.L74;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * 提示：
 *
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 100
 * - -10^4 <= matrix[i][j], target <= 10^4
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.searchMatrix(new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3) = " + s.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
        System.out.println("s.searchMatrix(new int[][]{{1, 3, 5}}, 4) = " + s.searchMatrix(new int[][]{{1, 3, 5}}, 4));
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target){
            return false;
        }
        int x = m - 1;
        if (matrix[x][0] == target){
            return true;
        }
        int l = 0, r = x;
        if (matrix[x][0] > target){
            do {
                x = l + (r - l) / 2;
                if (matrix[x][0] > target){
                    r = x - 1;
                } else if (matrix[x][0] < target){
                    l = x + 1;
                } else {
                    return true;
                }
            } while (l <= r);
            x = r;
        }
        l = 0;
        r = n - 1;
        int y;
        while (l <= r){
            y = l + (r - l) / 2;
            if (matrix[x][y] > target){
                r = y - 1;
            } else if (matrix[x][y] < target){
                l = y + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
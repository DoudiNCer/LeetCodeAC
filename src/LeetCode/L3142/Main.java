package LeetCode.L3142;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.satisfiesConditions(new int[][]{{1, 0, 2}, {1, 0, 2}}) = " +
                s.satisfiesConditions(new int[][]{{1, 0, 2}, {1, 0, 2}}));
    }
}

class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i + 1 < m && grid[i][j] != grid[i + 1][j]){
                    return false;
                }
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]){
                    return false;
                }
            }
        }
        return true;
    }
}
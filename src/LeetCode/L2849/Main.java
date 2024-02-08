package LeetCode.L2849;

/**
 * 给你四个整数 sx、sy、fx、fy  以及一个 非负整数 t 。
 *
 * 在一个无限的二维网格中，你从单元格 (sx, sy) 开始出发。每一秒，你 必须 移动到任一与之前所处单元格相邻的单元格中。
 *
 * 如果你能在 恰好 t 秒 后到达单元格 (fx, fy) ，返回 true ；否则，返回  false 。
 *
 * 单元格的 相邻单元格 是指该单元格周围与其至少共享一个角的 8 个单元格。你可以多次访问同一个单元格。
 *
 * 提示：
 *
 * - 1 <= sx, sy, fx, fy <= 10^9
 * - 0 <= t <= 10^9
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isReachableAtTime(2, 4, 7, 7, 6) = " + s.isReachableAtTime(2, 4, 7, 7, 6));
        System.out.println("s.isReachableAtTime(3, 1, 7, 3, 3) = " + s.isReachableAtTime(3, 1, 7, 3, 3));
    }
}

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int dx = Math.abs(sx - fx);
        int dy = Math.abs(sy - fy);
        int dt = Math.max(dx, dy);
        if (dt > t || (t == 1 && dt == 0)){
            return false;
        }
        return true;
    }
}
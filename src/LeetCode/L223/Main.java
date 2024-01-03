package LeetCode.L223;

/**
 * 给你 二维 平面上两个 由直线构成且边与坐标轴平行/垂直 的矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 * 提示：
 *
 * -104 <= ax1, ay1, ax2, ay2, bx1, by1, bx2, by2 <= 104
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2) = " + s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int cx1 = Math.min(ax1, bx1);
        int cy1 = Math.min(ay1, by1);
        int cx2 = Math.max(ax2, bx2);
        int cy2 = Math.max(ay2, by2);
        int cxp = cx2 - cx1;
        int cyp = cy2 - cy1;
        if (cxp == 0 || cyp == 0){
            return 0;
        }
        boolean[][] d = new boolean[cxp][cyp];
        for (int x = 0; x < cxp; x++){
            for (int y = 0; y < cyp; y++){
                d[x][y] = false;
            }
        }
        for (int x = ax1 - cx1; x < ax2 - cx1; x++){
            for (int y = ay1 - cy1; y < ay2 - cy1; y++){
                d[x][y] = true;
            }
        }
        for (int x = bx1 - cx1; x < bx2 - cx1; x++){
            for (int y = by1 - cy1; y < by2 - cy1; y++){
                d[x][y] = true;
            }
        }
        int result = 0;
        for (int x = 0; x < cxp; x++){
            for (int y = 0; y < cyp; y++){
                result += ((d[x][y]) ? 1 : 0);
            }
        }
        return result;
    }
}

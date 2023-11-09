package LeetCode.L42;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}) = " + s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("s.trap(new int[]{4,2,0,3,2,5}) = " + s.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}

class Solution {
    public int trap(int[] height) {
        int res = 0, lp = 0, rp = height.length - 1, h = 1;
        while (lp < rp - 1){
            while (lp < height.length && height[lp] < h){
                lp++;
            }
            while (rp > 0 && height[rp] < h){
                rp--;
            }
            int tmpr = rp - lp - 1;
            if (tmpr <= 0){
                break;
            }
            int minh = Math.min(height[lp], height[rp]);
            tmpr *= (minh - h + 1);
            for (int i = lp + 1; i < rp; i++){
                if (height[i] >= h){
                    tmpr -= Math.min((height[i] - h + 1), minh - h + 1);
                }
            }
            res += tmpr;
            h = minh + 1;
        }
        return res;
    }
}
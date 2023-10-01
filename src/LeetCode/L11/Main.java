package LeetCode.L11;

import java.util.Date;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Date start = new Date();
        System.out.println("s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}) = " + s.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("((new Date()).getTime() -start.getTime()) = " + ((new Date()).getTime() - start.getTime()));
        start = new Date();
        System.out.println("s.maxArea(new int[]{1, 2, 1}) = " + s.maxArea(new int[]{1, 2, 1}));
        System.out.println("((new Date()).getTime() -start.getTime()) = " + ((new Date()).getTime() - start.getTime()));
        start = new Date();
        System.out.println("s.maxArea(new int[]{1, 1}) = " + s.maxArea(new int[]{1, 1}));
        System.out.println("((new Date()).getTime() -start.getTime()) = " + ((new Date()).getTime() - start.getTime()));
        start = new Date();
        System.out.println("s.maxArea(new int[]{76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191}) = " + s.maxArea(new int[]{76, 155, 15, 188, 180, 154, 84, 34, 187, 142, 22, 5, 27, 183, 111, 128, 50, 58, 2, 112, 179, 2, 100, 111, 115, 76, 134, 120, 118, 103, 31, 146, 58, 198, 134, 38, 104, 170, 25, 92, 112, 199, 49, 140, 135, 160, 20, 185, 171, 23, 98, 150, 177, 198, 61, 92, 26, 147, 164, 144, 51, 196, 42, 109, 194, 177, 100, 99, 99, 125, 143, 12, 76, 192, 152, 11, 152, 124, 197, 123, 147, 95, 73, 124, 45, 86, 168, 24, 34, 133, 120, 85, 81, 163, 146, 75, 92, 198, 126, 191}));
        System.out.println("((new Date()).getTime() -start.getTime()) = " + ((new Date()).getTime() - start.getTime()));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int lp = 0, rp = height.length - 1;
        while (lp < rp){
            int tmp = (rp - lp) * Math.min(height[lp], height[rp]);
            if (tmp > max){
                max = tmp;
            }
            if (height[lp] < height[rp]){
                lp++;
            } else {
                rp--;
            }
        }
        return max;
    }
}
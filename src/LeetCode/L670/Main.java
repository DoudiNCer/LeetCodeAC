package LeetCode.L670;

import java.util.Arrays;

/**
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 *
 * 给定数字的范围是 [0, 108]
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.maximumSwap(2736) = " + s.maximumSwap(2736));
    }
}

class Solution {
    public int maximumSwap(int num) {
        char[] bits = Integer.toString(num).toCharArray();
        int len = bits.length;
        char[] minbits = Arrays.copyOf(bits, len);
        Arrays.sort(minbits);
        int mp = len - 1;
        while (mp > 0 && minbits[mp] == bits[len - mp - 1]){
            mp--;
        }
        if (mp == 0){
            return num;
        }
        int p = len - 1;
        while (bits[p] != minbits[mp]){
            p--;
        }
        bits[p] = bits[len - mp - 1];
        bits[len - mp - 1] = minbits[mp];
        return Integer.parseInt(String.valueOf(bits));
    }
}
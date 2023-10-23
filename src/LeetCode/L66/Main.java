package LeetCode.L66;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.plusOne(new int[]{1,2,3}) = " + Arrays.toString(s.plusOne(new int[]{1, 2, 3})));
        System.out.println("s.plusOne(new int[]{9,9,9}) = " + Arrays.toString(s.plusOne(new int[]{9, 9, 9})));
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0){
            digits[0] = 1;
            return digits;
        }
        // 是否进位
        boolean add = false;
        if ((digits[digits.length - 1] = digits[digits.length - 1] + 1) == 10){
            add = true;
            digits[digits.length - 1] = 0;
        }
        int i = digits.length - 2;
        while (add && i >= 0) {
            if ((digits[i] = digits[i] + 1) == 10){
                digits[i] = 0;
            } else {
                add = false;
            }
            i--;
        }
        if (add){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        } else {
            return digits;
        }
    }
}
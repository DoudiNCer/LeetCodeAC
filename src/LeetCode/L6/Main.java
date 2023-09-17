package LeetCode.L6;

import java.util.Objects;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("(Objects.equals(s.convert(\"PAYPALISHIRING\", 3), \"PAHNAPLSIIGYIR\")) = " + (Objects.equals(s.convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")));
        System.out.println("(Objects.equals(s.convert(\"AB\", 1), \"AB\")) = " + (Objects.equals(s.convert("AB", 1), "AB")));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++){
            sbs[i] = new StringBuilder();
        }
        int ar = 0;
        boolean d = true;
        for (int i = 0; i < s.length(); i++){
            sbs[ar].append(s.charAt(i));
            if (d){
                ar++;
                if (ar == numRows){
                    ar -= 2;
                    d = false;
                }
            } else {
                ar--;
                if (ar == -1){
                    ar = 1;
                    d = true;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : sbs) {
            result.append(sb);
        }
        return result.toString();
    }
}
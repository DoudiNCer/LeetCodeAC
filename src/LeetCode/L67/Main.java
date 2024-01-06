package LeetCode.L67;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 *
 *
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 *
 *
 * 提示：
 *
 * 1 <= a.length, b.length <= 10^4
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.addBinary(\"11\", \"1\") = " + s.addBinary("11", "1"));
        System.out.println("s.addBinary(\"1010\", \"1011\") = " + s.addBinary("1010", "1011"));
    }
}

class Solution {
    public String addBinary(String a, String b) {
        int acnt = a.length() - 1, bcnt = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        boolean ax = false;
        while (acnt >= 0 || bcnt >= 0){
            int tmp = ax ? 1 : 0;
            if (acnt >= 0){
                tmp += (a.charAt(acnt) - '0');
                acnt--;
            }
            if (bcnt >= 0){
                tmp += (b.charAt(bcnt) - '0');
                bcnt--;
            }
            switch (tmp) {
                case 0 -> sb.insert(0, '0');
                case 1 -> {
                    sb.insert(0, '1');
                    ax = false;
                }
                case 2 -> {
                    sb.insert(0, '0');
                    ax = true;
                }
                case 3 -> {
                    sb.insert(0, '1');
                    ax = true;
                }
            }
        }
        if (ax){
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
package LeetCode.L8;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.myAtoi(\"123\") = " + s.myAtoi("123"));
        System.out.println("s.myAtoi(\"   -42\") = " + s.myAtoi("   -42"));
        System.out.println("s.myAtoi(\"4193 with words\") = " + s.myAtoi("4193 with words"));
        System.out.println("s.myAtoi(\"-91283472332\") = " + s.myAtoi("-91283472332"));
        System.out.println("s.myAtoi(\"-+12\") = " + s.myAtoi("-+12"));
        System.out.println("s.myAtoi(\"+-12\") = " + s.myAtoi("+-12"));
        System.out.println("s.myAtoi(\"+\") = " + s.myAtoi("+"));
        System.out.println("s.myAtoi(\"-\") = " + s.myAtoi("-"));
        System.out.println("s.myAtoi(\"-21474836482\") = " + s.myAtoi("-21474836482"));
    }
}

class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0){
            return 0;
        }
        int p = 0;
        int result = 0;
        boolean overflow = false;
        boolean negative = false;

        while (p < s.length() && s.charAt(p) == ' '){
            p++;
        }
        if (p < s.length() && s.charAt(p) == '-'){
            negative = true;
            p++;
        } else if (p < s.length() && s.charAt(p) == '+'){
            p++;
        }
        while (p < s.length() && s.charAt(p) == '0'){
            p++;
        }
        while (p < s.length()){
            int px = s.charAt(p) - '0';
            if (px < 0 || px > 9){
                break;
            }
            if (result > 214748364){
                overflow = true;
                break;
            }
            if (result == 214748364){
                if (negative){
                    if (px > 7){
                        overflow = true;
                        break;
                    }
                } else {
                    if (px > 6){
                        overflow = true;
                        break;
                    }
                }
            }
            result *= 10;
            result += px;
            p++;
        }
        if (overflow){
            if (negative){
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        if (negative){
            result = -result;
        }
        return result;
    }
}

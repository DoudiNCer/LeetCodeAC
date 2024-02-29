package LeetCode.L557;

/**
 * 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 *
 * 输入： s = "Mr Ding"
 * 输出："rM gniD"
 *
 *
 * 提示：
 *
 * - 1 <= s.length <= 5 * 10^4
 * - s 包含可打印的 ASCII 字符。
 * - s 不包含任何开头或结尾空格。
 * - s 里 至少 有一个词。
 * - s 中的所有单词都用一个空格隔开。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.reverseWords(\"Let's take LeetCode contest\") = " + s.reverseWords("Let's take LeetCode contest"));
        System.out.println("s.reverseWords(\"Mr Ding\") = " + s.reverseWords("Mr Ding"));
    }
}

class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int sp = 0;
        while (sp < chars.length){
            int ep = sp;
            while (ep < chars.length && chars[ep] != ' '){
                ep++;
            }
            int rp = ep - 1;
            while (sp < rp){
                char p = chars[sp];
                chars[sp] = chars[rp];
                chars[rp] = p;
                sp++;
                rp--;
            }
            sp = ep + 1;
        }
        return String.valueOf(chars);
    }
}
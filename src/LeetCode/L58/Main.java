package LeetCode.L58;

/**
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 *
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.lengthOfLastWord(\"Hello World\") = " + s.lengthOfLastWord("Hello World"));
        System.out.println("s.lengthOfLastWord(\"   fly me   to   the moon  \") = " + s.lengthOfLastWord("   fly me   to   the moon  "));
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        int length = s.length() - s.lastIndexOf(" ") - 1;
        if (length == 0){
            int p = s.length() - 2;
            while (s.charAt(p) == ' '){
                p--;
            }
            s = s.substring(0, p + 1);
            length = s.length() - s.lastIndexOf(" ") - 1;
        }
        return length;
    }
}
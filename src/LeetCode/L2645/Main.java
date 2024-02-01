package LeetCode.L2645;

/**
 * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
 *
 * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
 *
 * 提示：
 *
 * 1 <= word.length <= 50
 * word 仅由字母 "a"、"b" 和 "c" 组成。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.addMinimum(\"b\") = " + s.addMinimum("b"));
        System.out.println("s.addMinimum(\"aaa\") = " + s.addMinimum("aaa"));
        System.out.println("s.addMinimum(\"abc\") = " + s.addMinimum("abc"));
    }
}

class Solution {
    public int addMinimum(String word) {
        int result = 0;
        char[] wchar = word.toCharArray();
        int len = wchar.length;
        char[] xchar = new char[]{'a', 'b', 'c'};
        int wp = 0, xp = 0;
        while (wp < len){
            while (wchar[wp] != xchar[xp % 3]){
                xp++;
                result++;
            }
            wp++;
            xp++;
        }
        result += (3 - xp % 3) % 3;
        return result;
    }
}
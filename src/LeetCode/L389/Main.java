package LeetCode.L389;

/**
 * 给定两个字符串 s 和 t ，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 *
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 *
 * 提示：
 *
 * - 0 <= s.length <= 1000
 * - t.length == s.length + 1
 * - s 和 t 只包含小写字母
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.findTheDifference(\"abcd\", \"abcde\") = " + s.findTheDifference("abcd", "abcde"));
    }
}

class Solution {
    public char findTheDifference(String s, String t) {
        int[] cnts = new int[26];
        for (char c : t.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int i = 0; i < cnts.length; i++) {
            if (cnts[i] == 1){
                return (char) ('a' + i);
            }
        }
        return 0;
    }
}
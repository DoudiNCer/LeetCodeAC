package LeetCode.L409;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 *
 * 输入:s = "a"
 * 输出:1
 * 示例 3：
 *
 * 输入:s = "aaaaaccc"
 * 输出:7
 *
 *
 * 提示:
 *
 * - 1 <= s.length <= 2000
 * - s 只由小写 和/或 大写英文字母组成
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.longestPalindrome(\"abccccdd\") = " + s.longestPalindrome("abccccdd"));
        System.out.println("s.longestPalindrome(\"a\") = " + s.longestPalindrome("a"));
        System.out.println("s.longestPalindrome(\"aaaaaccc\") = " + s.longestPalindrome("aaaaaccc"));
    }
}

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> cnts = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer cnt = cnts.get(c);
            if (cnt == null){
                cnt = 1;
            } else {
                cnt++;
            }
            cnts.put(c, cnt);
        }
        int result = 0;
        boolean x = false;
        for (Integer value : cnts.values()) {
            if ((value & 1) == 1){
                x = true;
                result += (value - 1);
            } else {
                result += value;
            }
        }
        if (x){
            result++;
        }
        return result;
    }
}
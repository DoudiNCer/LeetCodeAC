package LeetCode.L1143;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
 * 示例 2：
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
 * 示例 3：
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0 。
 *
 *
 * 提示：
 *
 * - 1 <= text1.length, text2.length <= 1000
 * - text1 和 text2 仅由小写英文字符组成。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.longestCommonSubsequence( \"abcde\", \"ace\") = " + s.longestCommonSubsequence("abcde", "ace"));
        System.out.println("s.longestCommonSubsequence(\"abc\", \"abc\") = " + s.longestCommonSubsequence("abc", "abc"));
        System.out.println("s.longestCommonSubsequence(\"abc\", \"def\") = " + s.longestCommonSubsequence("abc", "def"));
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[len1][len2];
        dp[0][0] = chars1[0] == chars2[0] ? 1: 0;
        if (dp[0][0] == 1){
            for (int i = 1; i < len1; i++){
                dp[i][0] = 1;
            }
            for (int j = 1; j < len2; j++){
                dp[0][j] = 1;
            }
        } else {
            int i = 0;
            while (i < len1 && chars1[i] != chars2[0]){
                dp[i][0] = 0;
                i++;
            }
            while (i < len1){
                dp[i][0] = 1;
                i++;
            }
            int j = 0;
            while (j < len2 && chars2[j] != chars1[0]){
                dp[0][j] = 0;
                j++;
            }
            while (j < len2){
                dp[0][j] = 1;
                j++;
            }
        }
        for (int i = 1; i < len1; i++){
            for (int j = 1; j < len2; j++){
                if (chars1[i] == chars2[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}

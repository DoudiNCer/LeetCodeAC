package LeetCode.L647;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 * 提示：
 *
 * - 1 <= s.length <= 1000
 * - s 由小写英文字母组成
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.countSubstrings(\"abc\") = " + s.countSubstrings("abc"));
        System.out.println("s.countSubstrings(\"aaa\") = " + s.countSubstrings("aaa"));
    }
}

class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        byte[] chars = new byte[len];
        s.getBytes(0, len, chars, 0);
        int result = 0;
        for (int i = 0; i < len; i++){
            int l = i, r= i;
            while (l >= 0 && r < len && chars[l] == chars[r]){
                result++;
                l--;
                r++;
            }
            l = i - 1;
            r = i;
            while (l >= 0 && r < len && chars[l] == chars[r]){
                result++;
                l--;
                r++;
            }
        }
        return result;
    }
}
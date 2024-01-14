package LeetCode.L125;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。
 *
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 *
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 *
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *
 *
 * 提示：
 *
 * - 1 <= s.length <= 2 * 10^5
 * - s 仅由可打印的 ASCII 字符组成
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isPalindrome(\"A man, a plan, a canal: Panama\") = " + s.isPalindrome("A man, a plan, a canal: Panama"));
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return true;
        }
        byte[] chars = new byte[len];
        s.getBytes(0, len, chars, 0);
        int l = 0, r = len - 1;
        while (l < r){
            if (!isWeNeed(chars, l)){
                l++;
                continue;
            }
            if (!isWeNeed(chars, r)){
                r--;
                continue;
            }
            if (chars[l] == chars[r]){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
    private boolean isWeNeed(byte[] chars, int cgp){
        if (chars[cgp] >= 'A' && chars[cgp] <= 'Z'){
            chars[cgp] += ('a' - 'A');
            return true;
        } else return (chars[cgp] >= 'a' && chars[cgp] <= 'z') || (chars[cgp] >= '0' && chars[cgp] <= '9');
    }
}
package LeetCode.L383;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 *
 * 提示：
 *
 * - 1 <= ransomNote.length, magazine.length <= 10^5
 * - ransomNote 和 magazine 由小写英文字母组成
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.canConstruct(\"a\", \"b\") = " + s.canConstruct("a", "b"));
        System.out.println("s.canConstruct(\"ab\", \"aa\") = " + s.canConstruct("ab", "aa"));
        System.out.println("s.canConstruct(\"aa\", \"aab\") = " + s.canConstruct("aa", "aab"));
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()){
            return false;
        }
        int[] cnts = new int[26];
        for (char c : magazine.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnts[c - 'a']--;
            if (cnts[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
package LeetCode.L242;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 *
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isAnagram(\"anagram\", \"nagaram\") = " + s.isAnagram("anagram", "nagaram"));
        System.out.println("s.isAnagram(\"rat\", \"car\") = " + s.isAnagram("rat", "car"));
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] chars = new int[26];
        for (char c : s.toCharArray()) {
            chars[(c - 'a')]++;
        }
        for (char c : t.toCharArray()) {
            chars[(c - 'a')]--;
            if (chars[(c - 'a')] < 0){
                return false;
            }
        }
        for (int a : chars) {
            if (a != 0){
                return false;
            }
        }
        return true;
    }
}
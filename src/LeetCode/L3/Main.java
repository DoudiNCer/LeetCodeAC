package LeetCode.L3;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.lengthOfLongestSubstring(\"aaa\") = " + s.lengthOfLongestSubstring("aaa"));
        System.out.println("s.lengthOfLongestSubstring(\"abcabcbb\") = " + s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("s.lengthOfLongestSubstring(\"au\") = " + s.lengthOfLongestSubstring("au"));
        System.out.println("s.lengthOfLongestSubstring(\"aba\") = " + s.lengthOfLongestSubstring("aba"));
        System.out.println("s.lengthOfLongestSubstring(\"abcd\") = " + s.lengthOfLongestSubstring("abcd"));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        } else if (s.length() == 1){
            return 1;
        }
        int maxLength = 0, left = 0, right = 0;
        Map<Character, Integer> chars = new HashMap<>(s.length());
        while (right < s.length()){
            if (chars.containsKey(s.charAt(right))){
                left = Math.max(left, chars.get(s.charAt(right)) + 1);
            }
            chars.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, (right - left) + 1);
            right++;
        }
        return maxLength;
    }
}
package LeetCode.L387;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 *
 *
 * 提示:
 *
 * - 1 <= s.length <= 10^5
 * - s 只包含小写字母
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.firstUniqChar(\"loveleetcode\") = " + s.firstUniqChar("loveleetcode"));
    }
}

class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        Map<Character, Integer> words = new HashMap<>(Math.min(26, len));
        for (int i = 0; i < len; i++){
            Integer ss = words.get(s.charAt(i));
            if (ss == null){
                ss = i;
            } else {
                ss = -1;
            }
            words.put(s.charAt(i), ss);
        }
        int result = len;
        for (Integer value : words.values()) {
            if (value != -1 && value < result){
                result = value;
            }
        }
        if (result == len){
            result = -1;
        }
        return result;
    }
}
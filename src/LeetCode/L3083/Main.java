package LeetCode.L3083;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s ，请你判断字符串 s 是否存在一个长度为 2 的子字符串，在其反转后的字符串中也出现。
 *
 * 如果存在这样的子字符串，返回 true；如果不存在，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "leetcode"
 *
 * 输出：true
 *
 * 解释：子字符串 "ee" 的长度为 2，它也出现在 reverse(s) == "edocteel" 中。
 *
 * 示例 2：
 *
 * 输入：s = "abcba"
 *
 * 输出：true
 *
 * 解释：所有长度为 2 的子字符串 "ab"、"bc"、"cb"、"ba" 也都出现在 reverse(s) == "abcba" 中。
 *
 * 示例 3：
 *
 * 输入：s = "abcd"
 *
 * 输出：false
 *
 * 解释：字符串 s 中不存在满足「在其反转后的字符串中也出现」且长度为 2 的子字符串。
 *
 *
 *
 * 提示：
 *
 * - 1 <= s.length <= 100
 * - 字符串 s 仅由小写英文字母组成。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isSubstringPresent(\"leetcode\") = " + s.isSubstringPresent("leetcode"));
    }
}

class Solution {
    public boolean isSubstringPresent(String s) {
        char[] chars = s.toCharArray();
        Set<Integer> strs = new HashSet<>();
        for (int i = 1; i < chars.length; i++){
            if (chars[i - 1] == chars[i]){
                return true;
            }
            strs.add((chars[i - 1] << 7) + chars[i]);
        }
        for (int i = 1; i < chars.length; i++){
            if (strs.contains((chars[i] << 7) + chars[i - 1])){
                return true;
            }
        }
        return false;
    }
}
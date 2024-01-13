package LeetCode.L1347;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 *
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 *
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * 示例 2：
 *
 * 输出：s = "leetcode", t = "practice"
 * 输出：5
 * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
 * 示例 3：
 *
 * 输出：s = "anagram", t = "mangaar"
 * 输出：0
 * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
 * 示例 4：
 *
 * 输出：s = "xxyyzz", t = "xxyyzz"
 * 输出：0
 * 示例 5：
 *
 * 输出：s = "friend", t = "family"
 * 输出：4
 *
 *
 * 提示：
 *
 * - 1 <= s.length <= 50000
 * - s.length == t.length
 * - s 和 t 只包含小写英文字母
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.minSteps(\"bab\", \"aba\") = " + s.minSteps("bab", "aba"));
    }
}

class Solution {
    public int minSteps(String s, String t) {
        if (s.equals(t)){
            return 0;
        }
        int len = s.length();
        Map<Character, Integer> cnts = new HashMap<>(len);
        for (char c : s.toCharArray()) {
            Integer cnt = cnts.get(c);
            if (cnt == null){
                cnt = 1;
            } else {
                cnt++;
            }
            cnts.put(c, cnt);
        }
        for (char c : t.toCharArray()) {
            Integer cnt = cnts.get(c);
            if (cnt != null){
                cnt--;
                cnts.put(c, cnt);
            }
        }
        int p = 0, n = 0;
        for (Integer v : cnts.values()) {
            if (v > 0){
                p += v;
            } else if (v < 0){
                n -= v;
            }
        }
        return Math.max(p, n);
    }
}
package LeetCode.L1662;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 *
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 *
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 *
 *
 * 提示：
 *
 * - 1 <= word1.length, word2.length <= 10^3
 * - 1 <= word1[i].length, word2[i].length <= 10^3
 * - 1 <= sum(word1[i].length), sum(word2[i].length) <= 10^3
 * word1[i] 和 word2[i] 由小写字母组成
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.arrayStringsAreEqual(new String[]{\"ab\", \"c\"}, new String[]{\"a\", \"bc\"}) = " + s.arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }
}

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        Deque<Character> queue = new LinkedList<>();
        for (String s : word1) {
            for (char c : s.toCharArray()) {
                queue.addLast(c);
            }
        }
        for (String s : word2) {
            for (char c : s.toCharArray()) {
                if (queue.isEmpty() || queue.pollFirst() != c){
                    return false;
                }
            }
        }
        return queue.isEmpty();
    }
}
package LeetCode.L844;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 *
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 *
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 *
 *
 * 提示：
 *
 * - 1 <= s.length, t.length <= 200
 * - s 和 t 只含有小写字母以及字符 '#'
 *
 *
 * 进阶：
 *
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.backspaceCompare(\"ab#c\", \"ad#c\") = " + s.backspaceCompare("ab#c", "ad#c"));
        System.out.println("s.backspaceCompare(\"ab##\", \"c#d#\") = " + s.backspaceCompare("ab##", "c#d#"));
        System.out.println("s.backspaceCompare(\"a#c\", \"b\") = " + s.backspaceCompare("a#c", "b"));
        System.out.println("s.backspaceCompare(\"y#fo##f\", \"y#f#o##f\") = " + s.backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> ss = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '#'){
                if (!ss.isEmpty()){
                    ss.pop();
                }
            } else {
                ss.push(c);
            }
        }
        Deque<Character> ps = new ArrayDeque<>();
        for (char c : t.toCharArray()) {
            if (c == '#'){
                if (!ps.isEmpty()){
                    ps.pop();
                }
            } else {
                ps.push(c);
            }
        }
        if (ss.size() != ps.size()){
            return false;
        }
        while (!ss.isEmpty()){
            if (ss.pop() != ps.pop()){
                return false;
            }
        }
        return true;
    }
}
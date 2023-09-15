package LeetCode;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isValid(\"[{}]()\") = " + s.isValid("[{}]()"));
        System.out.println("s.isValid(\"{()}}{\") = " + s.isValid("{()}}{"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> cst = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> cst.push(')');
                case '[' -> cst.push(']');
                case '{' -> cst.push('}');
                case ')', ']', '}' -> {
                    if (cst.isEmpty()) {
                        return false;
                    }
                    if (cst.pop() != c) {
                        return false;
                    }
                }
            }
        }
        return cst.isEmpty();
    }
}
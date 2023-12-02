package LeetCode.L32;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.longestValidParentheses(\"()\") = " + s.longestValidParentheses("()"));
        System.out.println("s.longestValidParentheses(\"()()\") = " + s.longestValidParentheses("()()"));
        System.out.println("s.longestValidParentheses(\"(()\") = " + s.longestValidParentheses("(()"));
        System.out.println("s.longestValidParentheses(\"\") = " + s.longestValidParentheses(""));
        System.out.println("s.longestValidParentheses(\"())\") = " + s.longestValidParentheses("())"));
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2){
            return 0;
        }
        int result = 0;
        Stack<Integer> ss = new Stack<>();
        ss.push(-1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                ss.push(i);
            } else {
                ss.pop();
                if (ss.isEmpty()){
                    ss.push(i);
                } else {
                    result = Math.max(result, i - ss.peek());
                }
            }
        }
        return result;
    }
}
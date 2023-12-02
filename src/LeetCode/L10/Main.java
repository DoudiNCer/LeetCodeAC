package LeetCode.L10;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isMatch(\"aa\", \"a\") = " + s.isMatch("aa", "a"));
        System.out.println("s.isMatch(\"aa\", \"a*\") = " + s.isMatch("aa", "a*"));
        System.out.println("s.isMatch(\"aa\", \".*\") = " + s.isMatch("aa", ".*"));
        System.out.println("s.isMatch(\"aab\", \"c*a*b\") = " + s.isMatch("aab", "c*a*b"));
    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        // 待匹配字符串长度
        int sLen = s.length();
        // 表达式长度
        int pLen = p.length();

        // 匹配信息
        boolean[][] matchR = new boolean[sLen + 1][pLen + 1];
        matchR[0][0] = true;
        for (int i = 0; i <= sLen; ++i) {
            for (int j = 1; j <= pLen; ++j) {
                // 当前位为“*”
                if (p.charAt(j - 1) == '*') {
                    // * 匹配零个前一字符，兜底
                    matchR[i][j] = matchR[i][j - 2];
                    // * 匹配一个或多个前一字符
                    if (matches(s, p, i, j - 1)) {
                        matchR[i][j] = matchR[i][j] || matchR[i - 1][j];
                    }
                } else {
                    // 普通情况，当前位匹配情况与上一位情况逻辑与
                    if (matches(s, p, i, j)) {
                        matchR[i][j] = matchR[i - 1][j - 1];
                    }
                }
            }
        }
        return matchR[sLen][pLen];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
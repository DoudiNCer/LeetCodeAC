package LeetCode.L22;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.generateParenthesis(8) = " + s.generateParenthesis(8));
    }
}

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, "", 0, 0);
        return result;
    }

    private void dfs(List<String> result, int n, String sb, int left, int right){
        if(left > n || right > n || left < right) return;
        if(sb.length() == 2 * n){
            result.add(sb);
            return;
        }
        left++;
        dfs(result, n, sb + "(", left, right);
        left--;
        right++;
        dfs(result, n, sb + ")", left, right);
    }
}
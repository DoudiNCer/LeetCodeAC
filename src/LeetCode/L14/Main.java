package LeetCode.L14;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"flower","flow","flight"};
        System.out.println("s.longestCommonPrefix(strs) = " + s.longestCommonPrefix(strs));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int x = 0;
        while (true){
            if (strs[0].length() < x + 1){
                return strs[0];
            }
            char chx = strs[0].charAt(x);
            for (int i = 1; i < strs.length; i++){
                if (strs[i].length() < x + 1 || strs[i].charAt(x) != chx){
                    return strs[0].substring(0, x);
                }
            }
            x++;
        }
    }
}

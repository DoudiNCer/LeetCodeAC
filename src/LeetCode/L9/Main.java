package LeetCode.L9;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isPalindrome(121) = " + s.isPalindrome(121));
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        long ltr = x;
        long rtl = 0;
        while(x != 0){
            rtl *= 10;
            rtl += x % 10;
            x /= 10;
        }
        return ltr == rtl;
    }
}
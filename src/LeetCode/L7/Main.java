package LeetCode.L7;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.reverse(123) = " + s.reverse(123));
        System.out.println("s.reverse(-123) = " + s.reverse(-123));
        System.out.println("s.reverse(1534236469) = " + s.reverse(1534236469));
    }
}

class Solution {
    public int reverse(int x) {
        boolean des = x < 0;
        String xs = Integer.toString(des ? -x : x);
        StringBuilder sb = new StringBuilder(xs);
        sb.reverse();
        if ((xs.length() >= Integer.toString(Integer.MAX_VALUE).length()) && (sb.toString().compareTo(Integer.toString(Integer.MAX_VALUE)) > 0)){
            return 0;
        }
        int i = Integer.parseInt(sb.toString());
        if (des){
            i = -i;
        }
        return i;
    }
}
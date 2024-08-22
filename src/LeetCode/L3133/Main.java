package LeetCode.L3133;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.minEnd(3, 4) = " + s.minEnd(3, 4));
        System.out.println("s.minEnd(2, 7) = " + s.minEnd(2, 7));
    }
}

class Solution {
    public long minEnd(int n, int x) {
        long result = 0, px = 1;
        n -= 1;
        while (n > 0 || x > 0){
            if (x % 2 == 1){
                result += px;
            } else {
                if (n % 2 == 1){
                    result += px;
                }
                n /= 2;
            }
            px *= 2;
            x /= 2;
        }
        return result;
    }
}
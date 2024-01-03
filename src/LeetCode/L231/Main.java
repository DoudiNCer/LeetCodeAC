package LeetCode.L231;

/**
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isPowerOfTwo(1) = " + s.isPowerOfTwo(1));
        System.out.println("s.isPowerOfTwo(16) = " + s.isPowerOfTwo(16));
        System.out.println("s.isPowerOfTwo(-16) = " + s.isPowerOfTwo(-16));
        System.out.println("s.isPowerOfTwo(1216456) = " + s.isPowerOfTwo(1216456));
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0){
            return false;
        }
        while (n != 0){
            int nx = n & 1;
            int np = n >> 1;
            if (nx != 0 && np != 0){
                return false;
            }
            n = np;
        }
        return true;
    }
}
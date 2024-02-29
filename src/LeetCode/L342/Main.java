package LeetCode.L342;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *
 *
 * 提示：
 *
 * - -2^31 <= n <= 2^31 - 1
 *
 *
 * 进阶：你能不使用循环或者递归来完成本题吗？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isPowerOfFour(16) = " + s.isPowerOfFour(16));
        System.out.println("s.isPowerOfFour(5) = " + s.isPowerOfFour(5));
        System.out.println("s.isPowerOfFour(1) = " + s.isPowerOfFour(1));
    }
}

class Solution {
    public boolean isPowerOfFour(int n) {
        return switch (n){
            case 1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864, 268435456, 1073741824 -> true;
            default -> false;
        };
    }
}
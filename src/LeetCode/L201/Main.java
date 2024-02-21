package LeetCode.L201;

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：left = 5, right = 7
 * 输出：4
 * 示例 2：
 *
 * 输入：left = 0, right = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：left = 1, right = 2147483647
 * 输出：0
 *
 *
 * 提示：
 *
 * - 0 <= left <= right <= 2^31 - 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.rangeBitwiseAnd(5, 7) = " + s.rangeBitwiseAnd(5, 7));
        System.out.println("s.rangeBitwiseAnd(0, 0) = " + s.rangeBitwiseAnd(0, 0));
        System.out.println("s.rangeBitwiseAnd(1, 2147483647) = " + s.rangeBitwiseAnd(1, 2147483647));
    }
}

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        char[] lchar = Integer.toBinaryString(left).toCharArray();
        char[] rchar = Integer.toBinaryString(right).toCharArray();
        if (lchar.length < rchar.length){
            return 0;
        }
        int i = 0;
        while (i < rchar.length && lchar[i] == rchar[i]){
            i++;
        }
        while (i < rchar.length){
            rchar[i] = '0';
            i++;
        }
        return Integer.parseInt(new String(rchar), 2);
    }
}
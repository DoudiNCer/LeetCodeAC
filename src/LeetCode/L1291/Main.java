package LeetCode.L1291;

import java.util.LinkedList;
import java.util.List;

/**
 * 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 *
 * 请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 *
 *
 *
 * 示例 1：
 *
 * 输出：low = 100, high = 300
 * 输出：[123,234]
 * 示例 2：
 *
 * 输出：low = 1000, high = 13000
 * 输出：[1234,2345,3456,4567,5678,6789,12345]
 *
 *
 * 提示：
 *
 * - 10 <= low <= high <= 10^9
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.sequentialDigits(100, 300) = " + s.sequentialDigits(100, 300));
        System.out.println("s.sequentialDigits(10, 10000) = " + s.sequentialDigits(10, 10000));
    }
}

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int len = Integer.toString(low).length();
        int maxlen = Integer.toString(high).length();
        char[] nums = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<Integer> result = new LinkedList<>();
        while (len <= maxlen){
            for (int i = 0; i < 10 - len; i++){
                int num = Integer.parseInt(String.copyValueOf(nums, i, len));
                if (num < low){
                    continue;
                }
                if (num > high){
                    break;
                }
                result.add(num);
            }
            len++;
        }
        return result;
    }
}
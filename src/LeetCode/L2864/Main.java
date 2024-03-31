package LeetCode.L2864;

/**
 * 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 *
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 *
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 *
 * 注意 返回的结果字符串 可以 含前导零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "010"
 * 输出："001"
 * 解释：因为字符串 s 中仅有一个 '1' ，其必须出现在最后一位上。所以答案是 "001" 。
 * 示例 2：
 *
 * 输入：s = "0101"
 * 输出："1001"
 * 解释：其中一个 '1' 必须出现在最后一位上。而由剩下的数字可以生产的最大数字是 "100" 。所以答案是 "1001" 。
 *
 *
 * 提示：
 *
 * - 1 <= s.length <= 100
 * - s 仅由 '0' 和 '1' 组成
 * - s 中至少包含一个 '1'
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.maximumOddBinaryNumber(\"010\") = " + s.maximumOddBinaryNumber("010"));
        System.out.println("s.maximumOddBinaryNumber(\"0101\") = " + s.maximumOddBinaryNumber("0101"));
    }
}

class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int cnt1 = 0;
        for (char c : chars) {
            if (c == '1'){
                cnt1++;
            }
        }
        {
            int i = 0;
            while (i < cnt1 - 1){
                chars[i] = '1';
                i++;
            }
            while (i < len - 1){
                chars[i] = '0';
                i++;
            }
            chars[len - 1] = '1';
        }
        return new String(chars);
    }
}
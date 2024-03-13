package LeetCode.L2785;

/**
 * 给你一个下标从 0 开始的字符串 s ，将 s 中的元素重新 排列 得到新的字符串 t ，它满足：
 *
 * 所有辅音字母都在原来的位置上。更正式的，如果满足 0 <= i < s.length 的下标 i 处的 s[i] 是个辅音字母，那么 t[i] = s[i] 。
 * 元音字母都必须以他们的 ASCII 值按 非递减 顺序排列。更正式的，对于满足 0 <= i < j < s.length 的下标 i 和 j  ，如果 s[i] 和 s[j] 都是元音字母，那么 t[i] 的 ASCII 值不能大于 t[j] 的 ASCII 值。
 * 请你返回结果字母串。
 *
 * 元音字母为 'a' ，'e' ，'i' ，'o' 和 'u' ，它们可能是小写字母也可能是大写字母，辅音字母是除了这 5 个字母以外的所有字母。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "lEetcOde"
 * 输出："lEOtcede"
 * 解释：'E' ，'O' 和 'e' 是 s 中的元音字母，'l' ，'t' ，'c' 和 'd' 是所有的辅音。将元音字母按照 ASCII 值排序，辅音字母留在原地。
 * 示例 2：
 *
 * 输入：s = "lYmpH"
 * 输出："lYmpH"
 * 解释：s 中没有元音字母（s 中都为辅音字母），所以我们返回 "lYmpH" 。
 *
 *
 * 提示：
 *
 * - 1 <= s.length <= 10^5
 * - s 只包含英语字母表中的 大写 和 小写 字母。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.sortVowels(\"lEetcOde\") = " + s.sortVowels("lEetcOde"));
    }
}

class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        int[] vcnts = new int[10];
        char[] vchars = new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o','u'};
        for (char c : chars) {
            switch (c) {
                case 'A' -> vcnts[0]++;
                case 'E' -> vcnts[1]++;
                case 'I' -> vcnts[2]++;
                case 'O' -> vcnts[3]++;
                case 'U' -> vcnts[4]++;
                case 'a' -> vcnts[5]++;
                case 'e' -> vcnts[6]++;
                case 'i' -> vcnts[7]++;
                case 'o' -> vcnts[8]++;
                case 'u' -> vcnts[9]++;
            }
        }
        for (int i = 0, p = 0; i < chars.length && p < 10; i++){
            switch (chars[i]) {
                case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> {
                    while (p < 10 && vcnts[p] == 0) {
                        p++;
                    }
                    chars[i] = vchars[p];
                    vcnts[p]--;
                }
            }
        }
        return new String(chars);
    }
}
package LeetCode.L451;

import java.util.Arrays;

/**
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 *
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 *
 * 提示:
 *
 * - 1 <= s.length <= 5 * 10^5
 * - s 由大小写英文字母和数字组成
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.frequencySort(\"tree\") = " + s.frequencySort("tree"));
    }
}

class Solution {
    public String frequencySort(String s) {
        int[][] cntArray = new int[62][2];
        for (char c : s.toCharArray()) {
            int x = getCharHash(c);
            cntArray[x][0] = c;
            cntArray[x][1]++;
        }
        Arrays.sort(cntArray, (a, b) -> b[1] - a[1]);
        StringBuilder sb = new StringBuilder();
        for (int[] lcnt : cntArray) {
            if (lcnt[0] != 0){
                sb.append(String.valueOf((char) lcnt[0]).repeat(Math.max(0, lcnt[1])));
            }
        }
        return sb.toString();
    }
    private int getCharHash(char c){
        if (c >= 'a'){
            return c - 'a' + 36;
        } else if (c >= 'A'){
            return c - 'A' + 10;
        } else {
            return c - '0';
        }
    }
}
package LeetCode.L119;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 *
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 *
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 *
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 *
 * 提示:
 *
 * - 0 <= rowIndex <= 33
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.getRow(3) = " + s.getRow(3));
        System.out.println("s.getRow(8) = " + s.getRow(8));
        System.out.println("s.getRow(1) = " + s.getRow(1));
        System.out.println("s.getRow(30) = " + s.getRow(30));
    }
}

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        result.add(1);
        long last = 1;
        for (int i = 1; i < rowIndex + 1; i++){
            last = last * (rowIndex - i + 1) / i;
            result.add((int) last);
        }
        return result;
    }
}
package LeetCode.L118;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 提示:
 *
 * - 1 <= numRows <= 30
 */
public class Main{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.generate(5) = " + s.generate(5));
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> tmp = new ArrayList<>(1);
        tmp.add(1);
        result.add(tmp);
        List<Integer> last = tmp;
        for (int i = 1; i < numRows; i++){
            tmp = new ArrayList<>(i + 1);
            tmp.add(1);
            for (int j = 0; j < i - 1; j++){
                tmp.add(last.get(j) + last.get(j + 1));
            }
            tmp.add(1);
            result.add(tmp);
            last = tmp;
        }
        return result;
    }
}
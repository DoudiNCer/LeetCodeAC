package LeetCode.L46;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.permute(new int[]{1,2,3}) = " + s.permute(new int[]{1, 2, 3}));
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> last = new HashSet<>(nums.length);
        for (int num : nums) {
            last.add(num);
        }
        backtrack(last, res, new ArrayList<>());
        return res;
    }

    private void backtrack(Set<Integer> last, List<List<Integer>> res, List<Integer> output){
        if (last.isEmpty()){
            res.add(output);
            return;
        }
        for (Integer i : last) {
            Set<Integer> lastx = new HashSet<>(last);
            lastx.remove(i);
            List<Integer> outputx = new ArrayList<>(output);
            outputx.add(i);
            backtrack(lastx, res, outputx);
        }
    }
}
package LeetCode.L78;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.subsets(new int[]{1, 2, 3}) = " + s.subsets(new int[]{1, 2, 3}));
    }
}

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int len = 1 << nums.length;
        List<List<Integer>> result = new ArrayList<>(len);
        for (int i = 0; i < len; i++){
            result.add(new ArrayList<>(nums.length));
        }
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < len; j++){
                List<Integer> tmp = result.get(j);
                if (((j >> i) & 1) == 0){
                    tmp.add(nums[i]);
                }
                result.set(j, tmp);
            }
        }
        return result;
    }
}
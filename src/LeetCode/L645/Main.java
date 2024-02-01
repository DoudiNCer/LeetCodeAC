package LeetCode.L645;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 *
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.findErrorNums(new int[]{1, 2, 2, 4}) = " + Arrays.toString(s.findErrorNums(new int[]{1, 2, 2, 4})));
    }
}

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set<Integer> exist = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (result[0] == 0){
                if (!exist.add(nums[i])){
                    result[0] = nums[i];
                }
            }
            result[1] += (i + 1);
            result[1] -= nums[i];
        }
        result[1] += result[0];
        return result;
    }
}
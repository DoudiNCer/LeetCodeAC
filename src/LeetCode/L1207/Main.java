package LeetCode.L1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 *
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 *
 *
 * 提示：
 *
 * - 1 <= arr.length <= 1000
 * - -1000 <= arr[i] <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.uniqueOccurrences(new int[]{1,2,2,1,1,3}) = " + s.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
    }
}

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length < 2){
            return true;
        }
        Map<Integer, Integer> cnts = new HashMap<>();
        for (int i : arr) {
            Integer cnt = cnts.get(i);
            if (cnt == null){
                cnt = 1;
            } else {
                cnt++;
            }
            cnts.put(i, cnt);
        }
        return cnts.size() == (new HashSet<>(cnts.values())).size();
    }
}
package LeetCode.L1481;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [5,5,4], k = 1
 * 输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 * 示例 2：
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3
 * 输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 *
 *
 * 提示：
 *
 * - 1 <= arr.length <= 10^5
 * - 1 <= arr[i] <= 10^9
 * - 0 <= k <= arr.length
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1) = " + s.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println("s.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3) = " + s.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
    }
}

class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
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
        int result = cnts.size();
        for (Integer cnt : cnts.values().stream().sorted().toList()) {
            if (k >= cnt){
                result--;
                k -= cnt;
            } else {
                return result;
            }
        }
        return 0;
    }
}
package LeetCode.L1743;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 *
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 *
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 *
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个 即可。
 *
 *
 *
 * 示例 1：
 *
 * 输入：adjacentPairs = [[2,1],[3,4],[3,2]]
 * 输出：[1,2,3,4]
 * 解释：数组的所有相邻元素对都在 adjacentPairs 中。
 * 特别要注意的是，adjacentPairs[i] 只表示两个元素相邻，并不保证其 左-右 顺序。
 * 示例 2：
 *
 * 输入：adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * 输出：[-2,4,1,-3]
 * 解释：数组中可能存在负数。
 * 另一种解答是 [-3,1,4,-2] ，也会被视作正确答案。
 * 示例 3：
 *
 * 输入：adjacentPairs = [[100000,-100000]]
 * 输出：[100000,-100000]
 *
 *
 * 提示：
 *
 * - nums.length == n
 * - adjacentPairs.length == n - 1
 * - adjacentPairs[i].length == 2
 * - 2 <= n <= 10^5
 * - -10^5 <= nums[i], ui, vi <= 10^5
 * - 题目数据保证存在一些以 adjacentPairs 作为元素对的数组 nums
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}}) = " + Arrays.toString(s.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}})));
    }
}

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int KEY = 53495043;
        int n = adjacentPairs.length + 1;
        Map<Integer, int[]> aps = new HashMap<>(n);
        for (int[] adjacentPair : adjacentPairs) {
            int[] pair = aps.get(adjacentPair[0]);
            if (pair == null){
                pair = new int[]{adjacentPair[1], KEY};
            } else {
                pair[1] = adjacentPair[1];
            }
            aps.put(adjacentPair[0], pair);
            pair = aps.get(adjacentPair[1]);
            if (pair == null){
                pair = new int[]{adjacentPair[0], KEY};
            } else {
                pair[1] = adjacentPair[0];
            }
            aps.put(adjacentPair[1], pair);
        }
        int[] result = new int[n];
        result[0] = KEY;
        for (Integer key : aps.keySet()) {
            int[] pair = aps.get(key);
            if (pair[1] == KEY){
                if (result[0] == KEY){
                    result[0] = key;
                    result[1] = pair[0];
                } else {
                    result[adjacentPairs.length] = key;
                    result[adjacentPairs.length - 1] = pair[0];
                }
            }
        }
        for (int i = 1; i < adjacentPairs.length - 1; i++){
            int[] pair = aps.get(result[i]);
            if (pair[0] == result[i - 1]){
                result[i + 1] = pair[1];
            } else {
                result[i + 1] = pair[0];
            }
        }
        return result;
    }
}
package LeetCode.L1128;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一组多米诺骨牌 dominoes 。
 *
 * 形式上，dominoes[i] = [a, b] 与 dominoes[j] = [c, d] 等价 当且仅当 (a == c 且 b == d) 或者 (a == d 且 b == c) 。即一张骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 * 示例 2：
 *
 * 输入：dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
 * 输出：3
 *
 *
 * 提示：
 *
 * - 1 <= dominoes.length <= 4 * 10^4
 * - dominoes[i].length == 2
 * - 1 <= dominoes[i][j] <= 9
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.numEquivDominoPairs(new int[][]{{1,2}, {2,1}, {3,4}, {5,6}}) = " + s.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
    }
}

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> cnts = new HashMap<>();
        int result = 0;
        for (int[] dominoe : dominoes) {
            int k = (dominoe[0] + dominoe[1]) * 10 + Math.min(dominoe[0], dominoe[1]);
            Integer cnt = cnts.get(k);
            if (cnt == null){
                cnt = 1;
            } else {
                cnt++;
            }
            cnts.put(k, cnt);
        }
        for (Integer value : cnts.values()) {
            if (value < 2){
                continue;
            }
            result += (value - 1) * value / 2;
        }
        return result;
    }
}
package LeetCode.L1094;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 *
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 *
 *
 * 提示：
 *
 * - 1 <= trips.length <= 1000
 * - trips[i].length == 3
 * - 1 <= numPassengersi <= 100
 * - 0 <= fromi < toi <= 1000
 * - 1 <= capacity <= 10^5
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4) = " + s.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println("s.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5) = " + s.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
    }
}

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[][] end = Arrays.copyOf(trips, trips.length);
        Arrays.sort(trips, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(end, Comparator.comparingInt(a -> a[2]));
        int start = trips[0][1], stop = end[end.length - 1][2];
        int sp = 0, ep = 0, cnt = 0;
        for (int i = start; i <= stop; i++){
            while (sp < trips.length && i == trips[sp][1]){
                cnt += trips[sp][0];
                sp++;
            }
            while (ep < end.length && i == end[ep][2]){
                cnt -= end[ep][0];
                ep++;
            }
            if (cnt > capacity){
                return false;
            }
        }
        return true;
    }
}

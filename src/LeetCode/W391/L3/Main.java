package LeetCode.W391.L3;

/**
 * 100240. 最小化曼哈顿距离 显示英文描述
 * 通过的用户数16
 * 尝试过的用户数33
 * 用户总通过次数17
 * 用户总提交次数40
 * 题目难度Hard
 * 给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
 *
 * 两点之间的距离定义为它们的曼哈顿距离。
 *
 * 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[3,10],[5,15],[10,2],[4,4]]
 * 输出：12
 * 解释：移除每个点后的最大距离如下所示：
 * - 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
 * - 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
 * - 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
 * - 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
 * 在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
 * 示例 2：
 *
 * 输入：points = [[1,1],[1,1],[1,1]]
 * 输出：0
 * 解释：移除任一点后，任意两点之间的最大距离都是 0 。
 *
 *
 * 提示：
 *
 * - 3 <= points.length <= 10^5
 * - points[i].length == 2
 * - 1 <= points[i][0], points[i][1] <= 10^8
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2}, {4, 4}}) = " + s.minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2}, {4, 4}}));
    }
}

class Solution {
    public int minimumDistance(int[][] points) {
//        Arrays.sort(points, Comparator.comparingInt((ToIntFunction<int[]>) a -> a[0]).thenComparingInt(a -> a[1]));
//        int ld = 0, rh = points.length - 1;
//        if (points[ld][0] == points[rh][0] && points[ld][1] == points[rh][1]){
//            return 0;
//        } else if (points[ld][0] == points[rh][0]){
//            return Math.min(points[rh - 1][1] - points[0][1], points[rh][1] - points[1][1]);
//        } else if (points[ld][1] == points[rh][1]){
//            return Math.min(points[rh - 1][0] - points[0][0], points[rh][0] - points[1][0]);
//        }
//        TreeMap<Integer, Set<int[]>> dists = new TreeMap<>(Comparator.comparingInt(a -> -a));
//        for (int i = 0; i < points.length; i++){
//            for (int j = i + 1; j < points.length; j++){
//                int pq = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
//                Set<int[]> pairs = dists.get(pq);
//                if (pairs == null){
//                    pairs = new HashSet<>();
//                }
//                pairs.add(new int[]{i, j});
//                dists.put(pq, pairs);
//            }
//        }
//        for (Integer key : dists.keySet()) {
//            System.out.print("key = " + key);
//            System.out.println(", dists.get(key) = " + dists.get(key));
//        }
//        Set<int[]> fp = dists.get(dists.firstKey());
//        Set<Integer> delpoints = new HashSet<>();
//        for (int[] pair : fp) {
//            delpoints.add(pair[0]);
//            delpoints.add(pair[1]);
//        }
//        while (!dists.isEmpty()){
//            dists.remove(dists.firstKey());
//            Set<int[]> fpp = dists.get(dists.firstKey());
//            boolean kill = true;
//            Set<Integer> ndp = new HashSet<>();
//            for (int[] pair : fpp) {
//                if (!delpoints.contains(pair[0]) && !delpoints.contains(pair[1])) {
//                    kill = false;
//                } else {
//                    if (delpoints.contains(pair[0])){
//                        ndp.add(pair[0]);
//                    }
//                    if (delpoints.contains(pair[1])){
//                        ndp.add(pair[1]);
//                    }
//                }
//            }
//            delpoints = ndp;
//            if (!kill){
//                return dists.firstKey();
//            }
//        }
        return 0;
    }
}
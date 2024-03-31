package LeetCode.L2368;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
 *
 * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
 *
 * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
 *
 * 注意，节点 0 不 会标记为受限节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * 输出：4
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
 * 示例 2：
 *
 *
 * 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * 输出：3
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
 *
 *
 * 提示：
 *
 * - 2 <= n <= 10^5
 * - edges.length == n - 1
 * - edges[i].length == 2
 * - 0 <= ai, bi < n
 * - ai != bi
 * - edges 表示一棵有效的树
 * - 1 <= restricted.length < n
 * - 1 <= restricted[i] < n
 * - restricted 中的所有值 互不相同
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5}) = " + s.reachableNodes(7, new int[][]{{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[]{4, 5}));
    }
}

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> rested = new HashSet<>(restricted.length);
        for (int i : restricted) {
            rested.add(i);
        }
        Map<Integer, List<Integer>> neighbourhoods = new HashMap<>(n);
        for (int[] edge : edges) {
            if (rested.contains(edge[0]) || rested.contains(edge[1])){
                continue;
            }
            List<Integer> neighbourhood = neighbourhoods.get(edge[0]);
            if (neighbourhood == null){
                neighbourhood = new LinkedList<>();
            }
            neighbourhood.add(edge[1]);
            neighbourhoods.put(edge[0], neighbourhood);
            neighbourhood = neighbourhoods.get(edge[1]);
            if (neighbourhood == null){
                neighbourhood = new LinkedList<>();
            }
            neighbourhood.add(edge[0]);
            neighbourhoods.put(edge[1], neighbourhood);
        }
        Set<Integer> reachableSet = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        reachableSet.add(0);
        while (!queue.isEmpty()){
            Integer node = queue.pollFirst();
            List<Integer> ns = neighbourhoods.get(node);
            if (ns == null){
                continue;
            }
            for (Integer ne : ns) {
                if (reachableSet.contains(ne)){
                    continue;
                }
                queue.addLast(ne);
                reachableSet.add(ne);
            }
        }
        return reachableSet.size();
    }
}
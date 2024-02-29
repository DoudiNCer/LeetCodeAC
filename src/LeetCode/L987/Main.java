package LeetCode.L987;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 *
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 *
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 *
 * 返回二叉树的 垂序遍历 序列。
 *
 * 提示：
 *
 * - 树中结点数目总数在范围 [1, 1000] 内
 * - 0 <= Node.val <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, new TreeNode(2, new TreeNode(4),
                                                             new TreeNode(5)
                                                      ),
                                         new TreeNode(3, new TreeNode(6),
                                                             new TreeNode(7)
                                                     )
                                  );
        System.out.println("s.verticalTraversal(t0) = " + s.verticalTraversal(t0));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, Map<Integer, List<Integer>>> table;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        table = new TreeMap<>();
        verticalTableBuild(root, 0, 0);
        List<List<Integer>> result = new LinkedList<>();
        for (Integer x : table.keySet()) {
            List<Integer> colume = new LinkedList<>();
            Map<Integer, List<Integer>> nodes = table.get(x);
            for (Integer y : nodes.keySet()) {
                List<Integer> node = nodes.get(y);
                node.sort(Comparator.comparingInt(a -> a));
                colume.addAll(node);
            }
            result.add(colume);
        }
        return result;
    }
    private void verticalTableBuild(TreeNode tree, int x, int y){
        Map<Integer, List<Integer>> colume = table.get(x);
        List<Integer> node;
        if (colume == null){
            colume = new TreeMap<>();
            node = new LinkedList<>();
        } else {
            node = colume.get(y);
            if (node == null){
                node = new LinkedList<>();
            }
        }
        node.add(tree.val);
        colume.put(y, node);
        table.put(x, colume);
        if (tree.left != null){
            verticalTableBuild(tree.left, x - 1, y + 1);
        }
        if (tree.right != null){
            verticalTableBuild(tree.right, x + 1, y + 1);
        }
    }
}
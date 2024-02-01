package LeetCode.L104;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 *
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 提示：
 *
 * 树中节点的数量在 [0, 10^4] 区间内。
 * -100 <= Node.val <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("s.maxDepth(t0) = " + s.maxDepth(t0));
        TreeNode t1 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("s.maxDepth(t1) = " + s.maxDepth(t1));
        TreeNode t2 = new TreeNode(1);
        System.out.println("s.maxDepth(t2) = " + s.maxDepth(t2));
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
    public int maxDepth(TreeNode root) {
        return RMD(root);
    }

    private int RMD(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        return 1 + Math.max(RMD(tree.left), RMD(tree.right));
    }

    private int NRMD(TreeNode tree) {
        int count = 0;
        List<TreeNode> line = new LinkedList<>();
        if (tree != null) {
            line.add(tree);
        }
        while (!line.isEmpty()){
            List<TreeNode> lt = new LinkedList<>();
            for (TreeNode t : line) {
                if (t.left != null) {
                    lt.add(t.left);
                }
                if (t.right != null) {
                    lt.add(t.right);
                }
            }
            count++;
            line = lt;
        }
        return count;
    }
}
package LeetCode.L111;

import java.util.Objects;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 提示：
 *
 * 树中节点数的范围在 [0, 10^5] 内
 * -1000 <= Node.val <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(2, null,
                             new TreeNode(3, null,
                                    new TreeNode(4, null,
                                           new TreeNode(5, null,
                                                  new TreeNode(6)
                                                       )
                                                )
                                         )
                                  );
        System.out.println("s.minDepth(t0) = " + s.minDepth(t0));

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
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        if (root.left != null && root.right != null){
            int lh = minDepth(root.left);
            int rh = minDepth(root.right);
            return Math.min(lh, rh) + 1;
        }
        return minDepth(Objects.requireNonNullElseGet(root.left, () -> root.right)) + 1;
    }
}
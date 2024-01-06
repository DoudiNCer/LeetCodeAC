package LeetCode.L404;

/**
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 *
 * 提示:
 *
 * 节点数在 [1, 1000] 范围内
 * -1000 <= Node.val <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        System.out.println("s.sumOfLeftLeaves(t0) = " + s.sumOfLeftLeaves(t0));
        TreeNode t1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, null, null));
        System.out.println("s.sumOfLeftLeaves(t1) = " + s.sumOfLeftLeaves(t1));
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
    public int sumOfLeftLeaves(TreeNode root) {
        return SLL(root, false);
    }

    private int SLL(TreeNode tree, boolean isLeft){
        if (tree == null){
            return 0;
        }
        int result = 0;
        if (tree.left == null && tree.right == null){
            return isLeft ? tree.val : 0;
        }
        result += SLL(tree.left, true);
        result += SLL(tree.right, false);
        return result;
    }
}
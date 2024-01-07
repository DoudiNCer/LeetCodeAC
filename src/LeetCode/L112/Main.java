package LeetCode.L112;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 提示：
 *
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(
                5, new TreeNode(4, new TreeNode(11, new TreeNode(7),
                                                               new TreeNode(2)),
                                                   null),
                       new TreeNode(8, new TreeNode(13),
                                           new TreeNode(4, null,
                                                   new TreeNode(2)))
        );
        System.out.println("s.hasPathSum(t0, 22) = " + s.hasPathSum(t0, 22));
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("s.hasPathSum(t1, 5) = " + s.hasPathSum(t1, 5));
        TreeNode t2 = null;
        System.out.println("s.hasPathSum(t2, 0) = " + s.hasPathSum(t2, 0));
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
    private int target;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return RHPL(root);
    }

    private boolean RHPL(TreeNode tree){
        if (tree == null){
            return false;
        }
        target -= tree.val;
        boolean result =  target == 0;
        if (tree.left == null && tree.right == null){
            target += tree.val;
            return result;
        }
        if (RHPL(tree.left)){
            return true;
        }
        result = RHPL(tree.right);
        target += tree.val;
        return result;
    }
}
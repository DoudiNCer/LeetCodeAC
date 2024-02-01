package LeetCode.L110;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 提示：
 *
 * - 树中的节点数在范围 [0, 5000] 内
 * - -10^4 <= Node.val <= 10^4
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(3, new TreeNode(9),
                                          new TreeNode(20, new TreeNode(15),
                                                               new TreeNode(7)
                                                      )
                                  );
        System.out.println("s.isBalanced(t0) = " + s.isBalanced(t0));
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
    private boolean result;
    public boolean isBalanced(TreeNode root) {
        result = true;
        RIB(root);
        return result;
    }
    private int RIB(TreeNode tree){
        if (!result || tree == null){
            return 0;
        }
        int lh = RIB(tree.left);
        int rh = RIB(tree.right);
        if (Math.abs(lh - rh) > 1){
            result = false;
            return 0;
        } else {
            return Math.max(lh, rh) + 1;
        }
    }
}
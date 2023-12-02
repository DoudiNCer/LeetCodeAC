package LeetCode.L98;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode r0 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("s.isValidBST(r0) = " + s.isValidBST(r0));
        TreeNode r1 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("s.isValidBST(r1) = " + s.isValidBST(r1));
        TreeNode t2 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println("s.isValidBST(t2) = " + s.isValidBST(t2));
        TreeNode r3 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println("s.isValidBST(r3) = " + s.isValidBST(r3));
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
    public boolean isValidBST(TreeNode root) {
        return root == null || isValidBSTi(root, false, root.val, false, root.val);
    }
    private boolean isValidBSTi(TreeNode root, boolean lLimit, int lL, boolean rLimit, int rL){
        if (root == null){
            return true;
        }
        if ((lLimit && root.val >= lL) || (rLimit && root.val <= rL)){
            return false;
        }
        if (root.left != null){
            if (root.left.val >= root.val){
                return false;
            }
            if (!isValidBSTi(root.left, true, root.val, rLimit, rL)){
                return false;
            }
        }
        if (root.right != null){
            if (root.right.val <= root.val){
                return false;
            }
            return isValidBSTi(root.right, lLimit, lL, true, rLimit ? Math.max(root.val, rL) : root.val);
        }
        return true;
    }
}
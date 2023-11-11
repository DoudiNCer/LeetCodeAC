package LeetCode.L100;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode p0 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q0 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("s.isSameTree(p0, q0) = " + s.isSameTree(p0, q0));
        TreeNode p1 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q1 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("s.isSameTree(p1, q1) = " + s.isSameTree(p1, q1));
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null){
            return q == null;
        }
        if (q == null){
            return false;
        }
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
    }
}
package LeetCode.L101;

import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 提示：
 *
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println("s.isSymmetric(t0) = " + s.isSymmetric(t0));
        TreeNode t1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));
        System.out.println("s.isSymmetric(t1) = " + s.isSymmetric(t1));
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
    public boolean isSymmetric(TreeNode root) {
        return NRIS(root);
    }

    private boolean NRIS(TreeNode root){
        Stack<TreeNode> ls = new Stack<>();
        Stack<TreeNode> rs = new Stack<>();
        TreeNode lp = root.left, rp = root.right;
        boolean result = true;
        while (lp != null || !ls.isEmpty()){
            if (lp != null){
                if (rp == null || lp.val != rp.val){
                    result = false;
                    break;
                }
                ls.push(lp);
                lp = lp.left;
                rs.push(rp);
                rp = rp.right;
            } else {
                if (rp != null){
                    result = false;
                    break;
                }
                lp = ls.pop();
                lp = lp.right;
                rp = rs.pop();
                rp = rp.left;
            }
        }
        if (result){
            if (rp != null || !rs.isEmpty()){
                result = false;
            }
        }
        return result;
    }
}

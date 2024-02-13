package LeetCode.L145;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 * 提示：
 *
 * - 树中节点的数目在范围 [0, 100] 内
 * - -100 <= Node.val <= 100
 *
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println("s.postorderTraversal(t0) = " + s.postorderTraversal(t0));
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
    public List<Integer> postorderTraversal(TreeNode root) {
        return RPT(root);
    }

    private List<Integer> RPT(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        result.addAll(RPT(root.left));
        result.addAll(RPT(root.right));
        result.add(root.val);
        return result;
    }
}
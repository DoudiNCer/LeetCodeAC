package LeetCode.L144;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        System.out.println("s.preorderTraversal(t0) = " + s.preorderTraversal(t0));
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
    public List<Integer> preorderTraversal(TreeNode root) {
        return RPT(root);
    }

    private List<Integer> RPT(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        result.add(root.val);
        result.addAll(RPT(root.left));
        result.addAll(RPT(root.right));
        return result;
    }

    private List<Integer> NRPT(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()){
            if (p != null){
                result.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return result;
    }
}
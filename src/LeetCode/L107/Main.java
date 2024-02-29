package LeetCode.L107;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 提示：
 *
 * - 树中节点数目在范围 [0, 2000] 内
 * - -1000 <= Node.val <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(3, new TreeNode(9),
                new TreeNode(20, new TreeNode(15),
                        new TreeNode(7)
                )
        );
        System.out.println("s.levelOrderBottom(t0) = " + s.levelOrderBottom(t0));
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> preLine = new LinkedList<>();
        preLine.add(root);
        while (!preLine.isEmpty()){
            List<Integer> lineResult = new LinkedList<>();
            List<TreeNode> nextLine = new LinkedList<>();
            for (TreeNode node : preLine) {
                lineResult.add(node.val);
                if (node.left != null){
                    nextLine.add(node.left);
                }
                if (node.right != null){
                    nextLine.add(node.right);
                }
            }
            preLine = nextLine;
            result.addFirst(lineResult);
        }
        return result;
    }
}
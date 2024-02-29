package LeetCode.L102;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(3, new TreeNode(9),
                                         new TreeNode(20, new TreeNode(15),
                                                              new TreeNode(7)
                                                     )
                                  );
        System.out.println("s.levelOrder(t0) = " + s.levelOrder(t0));
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
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
            result.add(lineResult);
        }
        return result;
    }
}
package LeetCode.L103;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 提示：
 *
 * - 树中节点数目在范围 [0, 2000] 内
 * - -100 <= Node.val <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(3, new TreeNode(9),
                                         new TreeNode(20, new TreeNode(15),
                                                              new TreeNode(7)
                                                     )
                                  );
        System.out.println("s.zigzagLevelOrder(t0) = " + s.zigzagLevelOrder(t0));
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        List<TreeNode> preLine = new LinkedList<>();
        preLine.add(root);
        boolean reverse = false;
        while (!preLine.isEmpty()){
             LinkedList<Integer> lineResult = new LinkedList<>();
             List<TreeNode> nextLine = new LinkedList<>();
            for (TreeNode node : preLine) {
                if (reverse){
                    lineResult.addFirst(node.val);
                } else {
                    lineResult.addLast(node.val);
                }
                if (node.left != null){
                    nextLine.add(node.left);
                }
                if (node.right != null){
                    nextLine.add(node.right);
                }
            }
            preLine = nextLine;
            result.add(lineResult);
            reverse = !reverse;
        }
        return result;
    }
}
package LeetCode.L199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 提示:
 *
 * - 二叉树的节点个数的范围是 [0,100]
 * - -100 <= Node.val <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, new TreeNode(2, null,
                                                 new TreeNode(5)
                                                      ),
                                          new TreeNode(5, null,
                                                new TreeNode(4)
                                                      )
                                  );
        System.out.println("s.rightSideView(t0) = " + s.rightSideView(t0));
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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return new ArrayList<>(0);
        }
        List<Integer> result = new LinkedList<>();
        List<TreeNode> line = new LinkedList<>();
        line.add(root);
        while (!line.isEmpty()){
            List<TreeNode> tmp = new LinkedList<>();
            TreeNode last = null;
            for (TreeNode tree : line) {
                if (tree.left != null){
                    tmp.add(tree.left);
                }
                if (tree.right != null){
                    tmp.add(tree.right);
                }
                last = tree;
            }
            result.add(last.val);
            line = tmp;
        }
        return result;
    }
}
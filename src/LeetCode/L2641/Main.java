package LeetCode.L2641;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。
 *
 * 如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。
 *
 * 请你返回修改值之后，树的根 root 。
 *
 * 注意，一个节点的深度指的是从树根节点到这个节点经过的边数。
 *
 * 提示：
 *
 * - 树中节点数目的范围是 [1, 10^5] 。
 * - 1 <= Node.val <= 10^4
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(5, new TreeNode(4, new TreeNode(1),
                                                             new TreeNode(10)
                                                      ),
                                          new TreeNode(9, null,
                                                  new TreeNode(7)
                                                      )
                                  );
        System.out.println("s.replaceValueInTree(t0) = " + s.replaceValueInTree(t0));
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
    public TreeNode replaceValueInTree(TreeNode root) {
        root = new TreeNode(0, root, null);
        List<TreeNode> line = new LinkedList<>();
        line.add(root);
        while (!line.isEmpty()){
            int sum = 0;
            for (TreeNode para : line) {
                if (para.left != null){
                    sum += para.left.val;
                }
                if (para.right != null){
                    sum += para.right.val;
                }
            }
            List<TreeNode> nline = new LinkedList<>();
            for (TreeNode para : line) {
                if (para.left != null && para.right != null){
                    int bsum = sum - para.left.val - para.right.val;
                    para.left.val = bsum;
                    para.right.val = bsum;
                    nline.add(para.left);
                    nline.add(para.right);
                } else if (para.left != null){
                    para.left.val = sum - para.left.val;
                    nline.add(para.left);
                } else if (para.right != null){
                    para.right.val = sum - para.right.val;
                    nline.add(para.right);
                }
            }
            line = nline;
        }
        return root.left;
    }
}
package LeetCode.L226;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 提示：
 *
 * - 树中节点数目范围在 [0, 100] 内
 * - -100 <= Node.val <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(4, new TreeNode(2, new TreeNode(1),
                                                              new TreeNode(3)
                                                      ),
                                          new TreeNode(7, new TreeNode(6),
                                                              new TreeNode(9)
                                                      )
                                  );
        System.out.println("s.invertTree(t0) = " + s.invertTree(t0));
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
    public TreeNode invertTree(TreeNode root) {
        if (root != null){
            var tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
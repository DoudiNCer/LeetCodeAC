package LeetCode.L1026;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 * 提示：
 *
 * - 树中的节点数在 2 到 5000 之间。
 * - 0 <= Node.val <= 10^5
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(8, new TreeNode(3, new TreeNode(1),
                                                             new TreeNode(6, new TreeNode(4),
                                                                                 new TreeNode(7)
                                                                         )
                                                      ),
                                         new TreeNode(10, null,
                                                 new TreeNode(14, new TreeNode(13),
                                                                                 null
                                                             )
                                                     )
                                  );
        System.out.println("s.maxAncestorDiff(t0) = " + s.maxAncestorDiff(t0));
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
    private int max;
    private List<TreeNode> para;
    public int maxAncestorDiff(TreeNode root) {
        para = new LinkedList<>();
        max = 0;
        RMAD(root);
        return max;
    }

    private void RMAD(TreeNode tree){
        if (tree == null){
            return;
        }
        for (TreeNode t : para) {
            int diff = Math.abs(t.val - tree.val);
            if (diff > max){
                max = diff;
            }
        }
        para.add(tree);
        RMAD(tree.left);
        RMAD(tree.right);
        if (!para.isEmpty()) {
            para.remove(para.size() - 1);
        }
    }
}
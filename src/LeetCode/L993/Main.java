package LeetCode.L993;

import java.util.LinkedList;
import java.util.List;

/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 * 提示：
 *
 * - 二叉树的节点数介于 2 到 100 之间。
 * - 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, new TreeNode(2, new TreeNode(4),
                                                                         null
                                                      ),
                                          new TreeNode(3)
                                  );
        System.out.println("s.isCousins(t0, 4, 3) = " + s.isCousins(t0, 4, 3));
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
    public boolean isCousins(TreeNode root, int x, int y) {
        root = new TreeNode(0, root, null);
        List<TreeNode> line = new LinkedList<>();
        line.add(root);
        while (!line.isEmpty()){
            List<TreeNode> nline = new LinkedList<>();
            Integer n = null;
            for (TreeNode para : line) {
                if (para.left != null){
                    if (n != null && para.left.val == n){
                        return true;
                    }
                    if (n == null){
                        if (para.left.val == x){
                            if (para.right != null && para.right.val == y){
                                return false;
                            }
                            n = y;
                        } else if (para.left.val == y){
                            if (para.right != null && para.right.val == x){
                                return false;
                            }
                            n = x;
                        }
                    }
                    nline.add(para.left);
                }
                if (para.right != null){
                    if (n != null && para.right.val == n){
                        return true;
                    }
                    if (n == null){
                        if (para.right.val == x){
                            n = y;
                        } else if (para.right.val == y){
                            n = x;
                        }
                    }
                    nline.add(para.right);
                }
            }
            if (n != null){
                return false;
            } else {
                line = nline;
            }
        }
        return false;
    }
}
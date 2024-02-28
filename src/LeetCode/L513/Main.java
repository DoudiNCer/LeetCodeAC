package LeetCode.L513;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *
 * 假设二叉树中至少有一个节点。
 *
 *
 *
 * 示例 1:
 *
 *
 *
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 *
 *
 *
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 *
 * 提示:
 *
 * - 二叉树的节点个数的范围是 [1,10^4]
 * - -2^31 <= Node.val <= 2^31 - 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("s.findBottomLeftValue(t0) = " + s.findBottomLeftValue(t0));
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
    private int mdepth;
    private int result;
    public int findBottomLeftValue(TreeNode root) {
        RFBLV(root, 1);
        return result;
    }

    private void RFBLV(TreeNode node, int depth){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            if (depth > mdepth){
                mdepth = depth;
                result = node.val;
            }
        } else {
            if (node.left != null){
                RFBLV(node.left, depth + 1);
            }
            if (node.right != null){
                RFBLV(node.right, depth + 1);
            }
        }
    }
}
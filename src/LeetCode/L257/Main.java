package LeetCode.L257;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 *
 *
 * 提示：
 *
 * - 树中节点的数目在范围 [1, 100] 内
 * - -100 <= Node.val <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        System.out.println("s.binaryTreePaths(t0) = " + s.binaryTreePaths(t0));
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
    private List<String> result;
    private StringBuilder sb;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new LinkedList<>();
        sb = new StringBuilder();
        if (root == null){
            return result;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null){
            result.add(sb.toString());
        } else {
            if (root.left != null) {
                dfs(root.left);
            }
            if (root.right != null) {
                dfs(root.right);
            }
        }
        return result;
    }

    private void dfs(TreeNode node) {
        int start = sb.length();
        sb.append("->").append(node.val);
        if (node.left == null && node.right == null) {
            result.add(sb.toString());
        } else {
            if (node.left != null) {
                dfs(node.left);
            }
            if (node.right != null) {
                dfs(node.right);
            }
        }
        sb.delete(start, sb.length());
    }
}
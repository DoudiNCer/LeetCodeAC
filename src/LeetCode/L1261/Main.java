package LeetCode.L1261;

import java.util.HashSet;
import java.util.Set;

/**
 * 给出一个满足下述规则的二叉树：
 *
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 *
 * 请你先还原二叉树，然后实现 FindElements 类：
 *
 * - FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * - bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 *
 * 提示：
 *
 * - TreeNode.val == -1
 * - 二叉树的高度不超过 20
 * - 节点的总数在 [1, 10^4] 之间
 * - 调用 find() 的总次数在 [1, 10^4] 之间
 * - 0 <= target <= 10^6
 */
public class Main {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(-1, null, new TreeNode(-1));
        FindElements fe = new FindElements(t0);
        System.out.println("t0 = " + t0);
        System.out.println("fe.find(1) = " + fe.find(1));
        System.out.println("fe.find(2) = " + fe.find(2));
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
class FindElements {

    private final Set<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        if (root == null){
            return;
        }
        root.val = 0;
        dfs(root);
    }

    public boolean find(int target) {
        return values.contains(target);
    }

    private void dfs(TreeNode node){
        if (node == null){
            return;
        }
        values.add(node.val);
        if (node.left != null){
            node.left.val = (node.val * 2 + 1);
            dfs(node.left);
        }
        if (node.right != null){
            node.right.val = (node.val * 2 + 2);
            dfs(node.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
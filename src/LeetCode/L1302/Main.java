package LeetCode.L1302;

/**
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 *
 *
 * 提示：
 *
 * - 树中节点数目在范围 [1, 10^4] 之间。
 * - 1 <= Node.val <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7),
                                                                                            null
                                                                         ),
                                                             new TreeNode(5)
                                                      ),
                                          new TreeNode(3, null,
                                                 new TreeNode(6, null,
                                                        new TreeNode(8)
                                                             )
                                                      )
                                  );
        System.out.println("s.deepestLeavesSum(t0) = " + s.deepestLeavesSum(t0));
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
    private int maxH = 0;
    private int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return sum;
    }

    private void dfs(TreeNode node, int h){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            if (maxH < h){
                maxH = h;
                sum = node.val;
            } else if (maxH == h){
                sum += node.val;
            }
            return;
        }
        if (node.left != null){
            dfs(node.left, h + 1);
        }
        if (node.right != null){
            dfs(node.right, h + 1);
        }
    }
}

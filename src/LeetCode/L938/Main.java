package LeetCode.L938;

/**
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 *
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 *
 * 提示：
 *
 * - 树中节点数目在范围 [1, 2 * 10^4] 内
 * - 1 <= Node.val <= 10^5
 * - 1 <= low <= high <= 10^5
 * - 所有 Node.val 互不相同
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(10, new TreeNode(5, new TreeNode(3),
                                                              new TreeNode(7)
                                                       ),
                                          new TreeNode(15, null,
                                                  new TreeNode(18)
                                                      )
                                  );
        System.out.println("s.rangeSumBST(t0, 7, 15) = " + s.rangeSumBST(t0, 7, 15));
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null){
            return 0;
        }
        int result = 0;
        if (root.val >= low && root.val <= high){
            result += root.val;
        }
        if (root.val > low){
            result += rangeSumBST(root.left, low, high);
        }
        if (root.val < high){
            result += rangeSumBST(root.right, low, high);
        }
        return result;
    }
}
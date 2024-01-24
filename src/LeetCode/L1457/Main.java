package LeetCode.L1457;

/**
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 *
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 *
 * 提示：
 *
 * - 给定二叉树的节点数目在范围 [1, 105] 内
 * - 1 <= Node.val <= 9
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(2, new TreeNode(3, new TreeNode(3),
                                                             new TreeNode(1)
                                                      ),
                                          new TreeNode(1, null,
                                                  new TreeNode(1)
                                                      )
                                  );
        System.out.println("s.pseudoPalindromicPaths(t0) = " + s.pseudoPalindromicPaths(t0));
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
    private int result;
    private int[] cnts;
    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null){
            return 0;
        }
        result = 0;
        cnts = new int[9];
        checkTree(root);
        return result;
    }

    private void checkTree(TreeNode tree){
        cnts[tree.val - 1]++;
        if (tree.left == null && tree.right == null){
            if (checkPath()){
                result++;
            }
        }
        if (tree.left != null){
            checkTree(tree.left);
        }
        if (tree.right != null){
            checkTree(tree.right);
        }
        cnts[tree.val - 1]--;
    }

    private boolean checkPath(){
        int cnt = 0;
        for (int i : cnts) {
            if ((i & 1) == 1){
                cnt++;
            }
        }
        return cnt <= 1;
    }
}
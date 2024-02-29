package LeetCode.L236;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 提示：
 *
 * - 树中节点数目在范围 [2, 10……5] 内。
 * - -10……9 <= Node.val <= 10……9
 * - 所有 Node.val 互不相同 。
 * - p != q
 * - p 和 q 均存在于给定的二叉树中。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(3, new TreeNode(5, new TreeNode(6),
                                                             new TreeNode(2, new TreeNode(7),
                                                                                 new TreeNode(4)
                                                                         )
                                                      ),
                                         new TreeNode(1, new TreeNode(0),
                                                             new TreeNode(8)
                                                     )
                                  );
        System.out.println("s.lowestCommonAncestor(t0, t0.left, t0.right) = " + s.lowestCommonAncestor(t0, t0.left, t0.right));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode result;
    private TreeNode p;
    private TreeNode q;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        result = null;
        check(root);
        return result;
    }

    private boolean check(TreeNode tree){
        if (tree == null){
            return false;
        }
        boolean lc = check(tree.left);
        if (result != null){
            return true;
        }
        boolean rc = check(tree.right);
        if (result != null){
            return true;
        }
        if ((lc && rc) || (lc || rc) && (tree.val == p.val || tree.val == q.val)){
            result = tree;
            return true;
        }
        return lc || rc || tree.val == p.val || tree.val == q.val;

    }
}
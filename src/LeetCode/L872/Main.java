package LeetCode.L872;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 提示：
 *
 * - 给定的两棵树结点数在 [1, 200] 范围内
 * - 给定的两棵树上的值在 [0, 200] 范围内
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t1 = new TreeNode(3, new TreeNode(5, new TreeNode(6),
                                                             new TreeNode(2, new TreeNode(7),
                                                                                 new TreeNode(4)
                                                                         )
                                                     ),
                                          new TreeNode(1, new TreeNode(9),
                                                              new TreeNode(8)
                                                      )
                                  );
        TreeNode t2 = new TreeNode(3, new TreeNode(5, new TreeNode(6),
                                                             new TreeNode(7)
                                                      ),
                                          new TreeNode(1, new TreeNode(4),
                                                              new TreeNode(2, new TreeNode(9),
                                                                                  new TreeNode(8)
                                                                          )
                                                      )
                                  );
        System.out.println("s.leafSimilar(t1, t2) = " + s.leafSimilar(t1, t2));
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = getLeafList(root1);
        List<Integer> l2 = getLeafList(root2);
        int size = l1.size();
        if (size != l2.size()){
            return false;
        }
        for (int i = 0; i < size; i++){
            if (!Objects.equals(l1.get(i), l2.get(i))){
                return false;
            }
        }
        return true;
    }

    private List<Integer> getLeafList(TreeNode tree){
        if (tree == null){
            return null;
        }
        List<Integer> result = new LinkedList<>();
        if (tree.left == null && tree.right == null){
            result.add(tree.val);
            return result;
        }
        if (tree.left == null){
            return getLeafList(tree.right);
        }
        if (tree.right == null){
            return getLeafList(tree.left);
        }
        result.addAll(getLeafList(tree.left));
        result.addAll(getLeafList(tree.right));
        return result;
    }
}
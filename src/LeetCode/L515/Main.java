package LeetCode.L515;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 *
 *
 * 示例1：
 *
 *
 *
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 示例2：
 *
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 *
 *
 * 提示：
 *
 * - 二叉树的节点个数的范围是 [0,10^4]
 * - -2^31 <= Node.val <= 2^31 - 1
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, new TreeNode(3, new TreeNode(5),
                                                             new TreeNode(3)
                                                      ),
                                          new TreeNode(2, null,
                                                 new TreeNode(9)
                                                      )
                                  );
        System.out.println("s.largestValues(t0) = " + s.largestValues(t0));
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
    private List<Integer> result;

    public List<Integer> largestValues(TreeNode root) {
        result = new ArrayList<>();
        RLV(root, 0);
        return result;
    }

    private void RLV(TreeNode node, int depth){
        if (node == null){
            return;
        }
        if (result.size() <= depth){
            result.add(node.val);
        } else if (result.get(depth) < node.val){
            result.set(depth, node.val);
        }
        RLV(node.left, depth + 1);
        RLV(node.right, depth + 1);
    }
}

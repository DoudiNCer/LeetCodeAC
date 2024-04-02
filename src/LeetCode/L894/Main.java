package LeetCode.L894;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 *
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 *
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：[[0,0,0]]
 *
 *
 * 提示：
 *
 * - 1 <= n <= 20
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.allPossibleFBT(7) = " + s.allPossibleFBT(7));
        System.out.println("s.allPossibleFBT(3) = " + s.allPossibleFBT(3));
        System.out.println("s.allPossibleFBT(1) = " + s.allPossibleFBT(1));
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
    public List<TreeNode> allPossibleFBT(int n) {
        LinkedList<TreeNode> result = new LinkedList<>();
        if ((n & 1) != 1) {
            return result;
        }
        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }
        n--;
        for (int i = 1; i < n; i += 2) {
            for (TreeNode lt : allPossibleFBT(i)) {
                for (TreeNode rt : allPossibleFBT(n - i)) {
                    result.add(new TreeNode(0, lt, rt));
                }
            }
        }
        return result;
    }
}

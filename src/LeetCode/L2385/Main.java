package LeetCode.L2385;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 *
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 *
 *  - 节点此前还没有感染。
 *  - 节点与一个已感染节点相邻。
 *
 * 返回感染整棵树需要的分钟数。
 *
 * 提示：
 *
 * - 树中节点的数目在范围 [1, 10^5] 内
 * - 1 <= Node.val <= 10^5
 * - 每个节点的值 互不相同
 * - 树中必定存在值为 start 的节点
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(1, new TreeNode(5, null,
                                                 new TreeNode(4, new TreeNode(9),
                                                                     new TreeNode(2)
                                                             )
                                                      ),
                                          new TreeNode(3, new TreeNode(10),
                                                              new TreeNode(6)
                                                      )
                                  );
        System.out.println("s.amountOfTime(t0, 3) = " + s.amountOfTime(t0, 3));
        TreeNode t1 = new TreeNode(1);
        System.out.println("s.amountOfTime(t1, 1) = " + s.amountOfTime(t1, 1));
        TreeNode t2 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5),
                                                                                                             null
                                                                                             ),
                                                                                            null
                                                                         ),
                                                                         null
                                                      ),
                                                     null
                                  );
        System.out.println("s.amountOfTime(t2, 1) = " + s.amountOfTime(t2, 1));
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
    private int last;
    private List<TreeNode> uninfected;

    public int amountOfTime(TreeNode root, int start) {
        TreeNode p = init(root, start);
        List<TreeNode> infected = new LinkedList<>();
        infected.add(p);
        int time = 0;
        while (last != 0) {
            List<TreeNode> infecting = new LinkedList<>();
            for (TreeNode t : infected) {
                if (t.left != null && t.left.val != 0) {
                    last--;
                    t.left.val = 0;
                    infecting.add(t.left);
                }
                if (t.right != null && t.right.val != 0) {
                    last--;
                    t.right.val = 0;
                    infecting.add(t.right);
                }
            }
            if (!uninfected.isEmpty()) {
                TreeNode t = uninfected.get(0);
                t.val = 0;
                infecting.add(t);
                last--;
                uninfected.remove(0);
            }
            infected = infecting;
            time++;
        }
        return time;
    }

    private TreeNode init(TreeNode root, int start) {
        last = -1;
        uninfected = new LinkedList<>();
        return countAndFind(root, start);
    }

    private TreeNode countAndFind(TreeNode tree, int start) {
        if (tree == null) {
            return null;
        }
        last++;
        TreeNode result = null;
        if (tree.val == start) {
            tree.val = 0;
            result = tree;
        }
        if (result == null) {
            result = countAndFind(tree.left, start);
        } else {
            countAndFind(tree.left, start);
        }
        if (result == null) {
            result = countAndFind(tree.right, start);
        } else {
            countAndFind(tree.right, start);
        }
        if (result != null && result != tree) {
            uninfected.add(tree);
        }
        return result;
    }
}
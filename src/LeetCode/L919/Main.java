package LeetCode.L919;

import java.util.LinkedList;

/**
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 *
 * 实现 CBTInserter 类:
 *
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 *
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 *
 *
 * 提示：
 *
 * - 树中节点数量范围为 [1, 1000]
 * - 0 <= Node.val <= 5000
 * - root 是完全二叉树
 * - 0 <= val <= 5000
 * - 每个测试用例最多调用 insert 和 get_root 操作 10^4 次
 */
public class Main {
    public static void main(String[] args) {
        CBTInserter inserter = new CBTInserter(new TreeNode(1, new TreeNode(2), null));
        System.out.println("inserter.insert(3) = " + inserter.insert(3));
        System.out.println("inserter.insert(4) = " + inserter.insert(4));
        System.out.println("inserter.get_root() = " + inserter.get_root());
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
class CBTInserter {
    private final TreeNode root;
    private final LinkedList<TreeNode> workList;

    public CBTInserter(TreeNode root) {
        this.root = root;
        int height = 0;
        workList = new LinkedList<>();
        workList.add(root);
        boolean kill = false;
        while (!kill) {
            for (int i = 0; i < (1 << height) && !kill; i++) {
                TreeNode next = workList.get(0);
                if (next.left == null || next.right == null) {
                    kill = true;
                }
                if (next.left != null && next.right != null) {
                    workList.removeFirst();
                }
                if (next.left != null) {
                    workList.add(next.left);
                }
                if (next.right != null) {
                    workList.add(next.right);
                }
            }
            height++;
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode para = workList.getFirst();
        if (para.left == null) {
            para.left = node;
        } else {
            para.right = node;
            workList.removeFirst();
        }
        workList.addLast(node);
        return para.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */

package LeetCode.L589;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * 提示：
 *
 * - 节点总数在范围 [0, 10^4]内
 * - 0 <= Node.val <= 10^4
 * - n 叉树的高度小于或等于 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Node n0 = new Node(1, new LinkedList<>());
        System.out.println("s.preorder(n0) = " + s.preorder(n0));
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    private List<Integer> result;

    public List<Integer> preorder(Node root) {
        result = new LinkedList<>();
        RDP(root);
        return result;
    }

    private void RDP(Node node){
        if (node == null){
            return;
        }
        result.add(node.val);
        for (Node child : node.children) {
            RDP(child);
        }
    }
}
package LeetCode.L429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * 提示：
 *
 * - 树的高度不会超过 1000
 * - 树的节点总数在 [0, 10^4] 之间
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Node n0 = new Node(1, new LinkedList<>());
        System.out.println("s.levelOrder(n0) = " + s.levelOrder(n0));
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null){
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lineResult = new ArrayList<>(size);
            for (int i = 0; i < size; i++){
                Node node = queue.removeFirst();
                lineResult.add(node.val);
                if (node.children != null && !node.children.isEmpty()){
                    queue.addAll(node.children);
                }
            }
            result.add(lineResult);
        }
        return result;
    }
}
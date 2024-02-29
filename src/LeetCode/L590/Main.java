package LeetCode.L590;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Node n0 = new Node(1, new LinkedList<>());
        System.out.println("s.postorder(n0) = " + s.postorder(n0));
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
    
    public List<Integer> postorder(Node root) {
        result = new ArrayList<>();
        RPO(root);
        return result;
    }

    private void RPO(Node node){
        if (node == null){
            return;
        }
        for (Node child : node.children) {
            RPO(child);
        }
        result.add(node.val);
    }
}
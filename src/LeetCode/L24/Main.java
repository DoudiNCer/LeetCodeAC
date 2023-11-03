package LeetCode.L24;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.swapPairs(null).toStrings() = " + s.swapPairs(null));
        System.out.println("s.swapPairs(ListNode.init(new int[]{1})).toStrings() = " + s.swapPairs(ListNode.init(new int[]{1})).toStrings());
        System.out.println("s.swapPairs(ListNode.init(new int[]{1,2,3,4,5,6,7})).toStrings() = " + s.swapPairs(ListNode.init(new int[]{1, 2, 3, 4, 5, 6, 7})).toStrings());
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p = new ListNode();
        p.next = head;
        head = p;
        while (p.next != null && p.next.next != null){
            ListNode tmp = p.next.next.next;
            p.next.next.next = p.next;
            p.next = p.next.next;
            p.next.next.next = tmp;
            p = p.next.next;
        }
        return head.next;
    }
}
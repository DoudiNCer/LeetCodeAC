package LeetCode.L19;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.init(new int[]{1,2,3,4,5});
        System.out.println(s.removeNthFromEnd(head, 2).toStrings());
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        for (ListNode i = head; i.next != null; i = i.next){
            length++;
        }
        if(length == n){
            return head.next;
        }
        ListNode x = head;
        for (int i = 1; i < length - n; i++){
            x = x.next;
        }
        x.next = x.next.next;
        return head;
    }
}
package LeetCode.L86;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head1 = ListNode.init(new int[]{1,4,3,2,5,2});
        System.out.println(s.partition(head1, 3).toStrings());
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
    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode(), sp = s;
        ListNode b = new ListNode(), bp = b;
        while (head != null){
            if (head.val < x){
                sp.next = head;
                sp = sp.next;
            } else {
                bp.next = head;
                bp = bp.next;
            }
            head = head.next;
        }
        sp.next = b.next;
        bp.next = null;
        return s.next;
    }
}
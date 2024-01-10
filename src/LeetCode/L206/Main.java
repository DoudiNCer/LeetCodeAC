package LeetCode.L206;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 提示：
 *
 * - 链表中节点的数目范围是 [0, 5000]
 * - -5000 <= Node.val <= 5000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l0 = new ListNode(new int[]{1,2,3,4,5});
        System.out.println("s.reverseList(l0) = " + s.reverseList(l0).toStrings());
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode b = null, m = head, e = head.next;
        while (true){
            m.next = b;
            if(e == null){
                break;
            }
            b = m;
            m = e;
            e = e.next;
        }
        head = m;
        return head;
    }
}
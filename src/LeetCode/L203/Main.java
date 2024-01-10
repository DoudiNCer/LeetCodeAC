package LeetCode.L203;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * 提示：
 *
 * - 列表中的节点数目在范围 [0, 10^4] 内
 * - 1 <= Node.val <= 50
 * - 0 <= val <= 50
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l0 = new ListNode(new int[]{1,2,6,3,4,5,6});
        System.out.println("s.removeElements(l0, 6) = " + s.removeElements(l0, 6).toStrings());
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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        if (head == null){
            return null;
        }
        ListNode p = head;
        while (p.next != null){
            if (p.next.val == val){
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
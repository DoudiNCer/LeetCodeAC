package LeetCode.L82;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 提示：
 *
 * - 链表中节点数目在范围 [0, 300] 内
 * - -100 <= Node.val <= 100
 * - 题目数据保证链表已经按升序 排列
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l0 = new ListNode(new int[]{1, 1, 1, 2, 3});
        System.out.println("s.deleteDuplicates(l0) = " + s.deleteDuplicates(l0).toStrings());
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode();
        p.next = head;
        head = p;
        while (p.next != null){
            if (p.next.next != null && p.next.val == p.next.next.val){
                while (p.next.next != null && p.next.val == p.next.next.val){
                    p.next.next = p.next.next.next;
                }
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head.next;
    }
}
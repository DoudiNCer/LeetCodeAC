package LeetCode.L83;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] h = new int[]{1,1,2,3,3};
        ListNode head = ListNode.init(h);
        System.out.println(s.deleteDuplicates(head).toStrings());
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
        ListNode p = head;
        while (p != null){
            ListNode q = p;
            while (q != null && p.val == q.val){
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
    }
}
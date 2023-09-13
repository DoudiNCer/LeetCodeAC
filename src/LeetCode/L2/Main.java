package LeetCode.L2;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] l1 = {9,9,9,9,9,9,9}, l2 = {9, 9, 9};
        ListNode i1 = ListNode.init(6, l1), i2 = ListNode.init(3, l2);
        System.out.println(s.addTwoNumbers(i1, i2).toStrings());
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(l1.val + l2.val);
        ListNode rp = result;
        byte jw = 0;
        if (result.val > 9){
            jw = 1;
            result.val -= 10;
        }
        while(l1.next != null || l2.next != null || jw != 0){
            rp.next = new ListNode();
            if (l1.next != null){
                rp.next.val += l1.next.val;
                ListNode p = l1;
                l1 = l1.next;
            }
            if (l2.next != null){
                rp.next.val += l2.next.val;
                ListNode p = l2;
                l2 = l2.next;
            }
            rp.next.val += jw;
            if (rp.next.val > 9){
                rp.next.val -= 10;
                jw = 1;
            } else {
                jw = 0;
                if (l1 == null && l2 != null){
                    rp.next.next = l2.next.next;
                    return result;
                }
                if (l2 == null && l1 != null){
                    rp.next.next = l1.next.next;
                    return result;
                }
            }
            rp = rp.next;
        }
        return result;
    }
}
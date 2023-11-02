package LeetCode.L23;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Main {
    public static void main(String[] args) {

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        ListNode result = new ListNode();
        ListNode p = new ListNode();
        p.next = result;
        while(true) {
            int mini = -1;
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null){
                    mini = i;
                    break;
                }
            }
            if (mini == -1){
                if (p.next == result){
                    result = null;
                }
                break;
            }
            for (int i = mini; i < lists.length; i++){
                if (lists[i] != null && lists[i].val < lists[mini].val){
                    mini = i;
                }
            }
            p.next.val = lists[mini].val;
            lists[mini] = lists[mini].next;
            p.next.next = new ListNode();
            p = p.next;
        }
        p.next = null;
        return result;
    }
}
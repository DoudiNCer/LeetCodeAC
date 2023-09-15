package LeetCode.L21;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] list1 = {1, 2, 4}, list2 = {1, 3, 4};
        ListNode l1 = ListNode.init(3, list1), l2 = ListNode.init(3, list2);
        System.out.println(s.mergeTwoLists(l1, l2).toStrings());
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode result = new ListNode();
        if (list1.val > list2.val){
            result.val = list2.val;
            list2 = list2.next;
        } else {
            result.val = list1.val;
            list1 = list1.next;
        }
        ListNode p = result;
        if (list1 == null){
            p.next = list2;
            return result;
        }
        if (list2 == null){
            p.next = list1;
            return result;
        }
        while (list1 != null || list2 != null){
            if (list1.val > list2.val){
                p.next = new ListNode(list2.val);
                list2 = list2.next;
            } else {
                p.next = new ListNode(list1.val);
                list1 = list1.next;
            }
            p = p.next;
            if (list1 == null){
                p.next = list2;
                return result;
            }
            if (list2 == null){
                p.next = list1;
                return result;
            }
        }
        return result;
    }
}

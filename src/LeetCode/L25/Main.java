package LeetCode.L25;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.reverseKGroup(ListNode.init(new int[]{1,2,3,4,5}), 2).toStrings() = " + s.reverseKGroup(ListNode.init(new int[]{1, 2, 3, 4, 5}), 2).toStrings());
        System.out.println();
        System.out.println("s.reverseKGroup(ListNode.init(new int[]{1,2,3,4,5,6,7}), 4).toStrings() = " + s.reverseKGroup(ListNode.init(new int[]{1, 2, 3, 4, 5, 6, 7}), 4).toStrings());
        System.out.println();
        System.out.println("s.reverseKGroup(ListNode.init(new int[]{1,2,3,4,5}), 3).toStrings() = " + s.reverseKGroup(ListNode.init(new int[]{1, 2, 3, 4, 5}), 3).toStrings());
        System.out.println();
        System.out.println("s.reverseKGroup(ListNode.init(new int[]{1,2}), 2).toStrings() = " + s.reverseKGroup(ListNode.init(new int[]{1, 2}), 2).toStrings());
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null){
            return head;
        }
        ListNode p = new ListNode();
        p.next = head;
        head = p;
        while (true){
            ListNode q = p;
            int i = 0;
            while (i < k){
                if (q.next == null){
                    break;
                } else {
                    q = q.next;
                    i++;
                }
            }
            if (i < k){
                break;
            }
            ListNode np = p.next;
            reverseLink(p, q.next);
            p = np;
        }
        return head.next;
    }

    private void reverseLink(ListNode p, ListNode q){
        ListNode b = q, m = p.next, e = m.next;
        while (true){
            m.next = b;
            if (e == q){
                break;
            }
            b = m;
            m = e;
            e = e.next;
        }
        p.next = m;
    }
}
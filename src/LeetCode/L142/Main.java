package LeetCode.L142;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 提示：
 *
 * 链表中节点的数目范围在范围 [0, 104] 内
 * -105 <= Node.val <= 105
 * pos 的值为 -1 或者链表中的一个有效索引
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h0 = new ListNode(1, new int[]{3,2,0,-4});
        ListNode s0 = s.detectCycle(h0);
        System.out.println("s.detectCycle(h0) = " + (s0 == null ? "null" : s0) );
        ListNode h1 = new ListNode(0, new int[]{1,2});
        ListNode s1 = s.detectCycle(h1);
        System.out.println("s.detectCycle(h1) = " + (s1 == null ? "null" : s1));
        ListNode h2 = new ListNode(-1, new int[]{1});
        ListNode s2 = s.detectCycle(h2);
        System.out.println("s.detectCycle(h2) = " + (s2 == null ? "null" : s2));
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode f =head, s = head;
        do {
            if (s == null || f == null || f.next == null){
                return null;
            }
            s = s.next;
            f = f.next.next;
        } while (f != s);
        s = head;
        while (s != f){
            s = s.next;
            f = f.next;
        }
        return s;
    }
}
package LeetCode.L141;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h0 = new ListNode(1, new int[]{3,2,0,-4});
        System.out.println("s.hasCycle(h0) = " + s.hasCycle(h0));
        ListNode h1 = new ListNode(0, new int[]{1,2});
        System.out.println("s.hasCycle(h1) = " + s.hasCycle(h1));
        ListNode h2 = new ListNode(-1, new int[]{1});
        System.out.println("s.hasCycle(h2) = " + s.hasCycle(h2));
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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode f = head, s = head;
        do {
            if (s == null || f == null || f.next == null){
                return false;
            }
            s = s.next;
            f = f.next.next;
        } while (f != s);
        return true;
    }
}
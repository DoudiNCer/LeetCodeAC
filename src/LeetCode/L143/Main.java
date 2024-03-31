package LeetCode.L143;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 *
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 *
 * 提示：
 *
 * - 链表的长度范围为 [1, 5 * 10^4]
 * - 1 <= node.val <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l0 = new ListNode(new int[]{1, 2, 3, 4});
        s.reorderList(l0);
        System.out.println("l0 = " + l0);
        ListNode l1 = new ListNode(new int[]{1, 2, 3, 4, 5});
        s.reorderList(l1);
        System.out.println("l1 = " + l1);
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
    public void reorderList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode p = head;
        while (p != null){
            stack.push(p);
            p = p.next;
        }
        int size = stack.size();
        int cnt = size >> 1;
        p = head;
        while (cnt-- > 0){
            ListNode q = p.next;
            p.next = stack.pop();
            p.next.next = q;
            if (cnt == 0){
                q.next = null;
            }
            p = q;
        }
    }
}

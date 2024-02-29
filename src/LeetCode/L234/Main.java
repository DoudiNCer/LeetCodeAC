package LeetCode.L234;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 提示：
 *
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 *
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.isPalindrome(new ListNode(new int[]{1, 2, 2, 1})) = " + s.isPalindrome(new ListNode(new int[]{1, 2, 2, 1})));
        System.out.println("s.isPalindrome(new ListNode(new int[]{1, 2})) = " + s.isPalindrome(new ListNode(new int[]{1, 2})));
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
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode p = head;
        while (p != null){
            stack.push(p.val);
            p = p.next;
        }
        int cnt = stack.size() / 2;
        p = head;
        while (cnt > 0){
            if (p.val != stack.pop()){
                return false;
            }
            p = p.next;
            cnt--;
        }
        return true;
    }
}
package LeetCode.L876;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 *
 *
 * 提示：
 *
 * - 链表的结点数范围是 [1, 100]
 * - 1 <= Node.val <= 100
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.middleNode(new ListNode(new int[]{1, 2, 3, 4, 5})) = " + s.middleNode(new ListNode(new int[]{1, 2, 3, 4, 5})));
        System.out.println("s.middleNode(new ListNode(new int[]{1, 2, 3, 4, 5, 6})) = " + s.middleNode(new ListNode(new int[]{1, 2, 3, 4, 5, 6})));
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
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode p = new ListNode();
        p.next = head;
        head = p;
        while (p.next != null){
            p = p.next;
            cnt++;
        }
        cnt >>= 1;
        cnt++;
        p = head;
        while (cnt > 0){
            p = p.next;
            cnt--;
        }
        return p;
    }
}
package LeetCode.L92;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("s.reverseBetween(ListNode.init(new int[]{1,2,3,4,5}), 2, 4).toStrings() = " + s.reverseBetween(ListNode.init(new int[]{1, 2, 3, 4, 5}), 2, 4).toStrings());
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right){
            return head;
        }
        ListNode p = new ListNode();
        p.next = head;
        head = p;
        for (int i = 1; i < left; i++){
            p = p.next;
        }
        ListNode q = p.next;
        for (int j = left; j < right; j++){
            q = q.next;
        }
        reverseLink(p, q.next);
        return head.next;
    }

    /**
     * 反转链表
     * @param p 待反转链表前一个元素
     * @param q 待反转链表后一个元素
     */
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

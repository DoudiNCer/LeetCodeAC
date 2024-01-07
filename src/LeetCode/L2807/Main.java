package LeetCode.L2807;

/**
 * 给你一个链表的头 head ，每个结点包含一个整数值。
 *
 * 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。
 *
 * 请你返回插入之后的链表。
 *
 * 两个数的 最大公约数 是可以被两个数字整除的最大正整数。
 *
 * 提示：
 *
 * 链表中结点数目在 [1, 5000] 之间。
 * 1 <= Node.val <= 1000
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l0 = new ListNode(new int[]{18,6,10,3});
        System.out.println("s.insertGreatestCommonDivisors(l0) = " + s.insertGreatestCommonDivisors(l0).toStrings());
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode x = head, y = head.next;
        if (y == null) {
            return head;
        }
        while (y != null){
            x.next = new ListNode(GCD(x.val, y.val), y);
            x = y;
            y = y.next;
        }
        return head;
    }

    private int GCD(int x, int y){
        if (x == 0){
            return y;
        }
        if (y == 0){
            return x;
        }
        if ((x & 1) == 0 && (y & 1) == 0){
            return 2 * GCD(x >> 1, y >> 1);
        } else if ((x & 1) == 0){
            return GCD(x >> 1, y);
        } else if ((y & 1) == 0){
            return GCD(x, y >> 1);
        } else {
            return GCD(Math.abs(x - y), Math.min(x, y));
        }
    }
}
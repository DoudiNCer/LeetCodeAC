package LeetCode.L2487;

import java.util.TreeMap;

/**
 * 给你一个链表的头节点 head 。
 *
 * 移除每个右侧有一个更大数值的节点。
 *
 * 返回修改后链表的头节点 head 。
 *
 * 提示：
 *
 * 给定列表中的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l = ListNode.init(new int[]{138, 466, 216, 67, 642, 978, 264, 136, 463, 331, 60, 600, 223, 275, 856, 809, 167, 101, 846, 165, 575, 276, 409, 590, 733, 200, 839, 515, 852, 615, 8, 584, 250, 337, 537, 63, 797, 900, 670, 636, 112, 701, 334, 422, 780, 552, 912, 506, 313, 474, 183, 792, 822, 661, 37, 164, 601, 271, 902, 792, 501, 184, 559, 140, 506, 94, 161, 167, 622, 288, 457, 953, 700, 464, 785, 203, 729, 725, 422, 76, 191, 195, 157, 854, 730, 577, 503, 401, 517, 692, 42, 135, 823, 883, 255, 111, 334, 365, 513, 338, 65, 600, 926, 607, 193, 763, 366, 674, 145, 229, 700, 11, 984, 36, 185, 475, 204, 604, 191, 898, 876, 762, 654, 770, 774, 575, 276, 165, 610, 649, 235, 749, 440, 607, 962, 747, 891, 943, 839, 403, 655, 22, 705, 416, 904, 765, 905, 574, 214, 471, 451, 774, 41, 365, 703, 895, 327, 879, 414, 821, 363, 30, 130, 14, 754, 41, 494, 548, 76, 825, 899, 499, 188, 982, 8, 890, 563, 438, 363, 32, 482, 623, 864, 161, 962, 678, 414, 659, 612, 332, 164, 580, 14, 633, 842, 969, 792, 777, 705, 436, 750, 501, 395, 342, 838, 493, 998, 112, 660, 961, 943, 721, 480, 522, 133, 129, 276, 362, 616, 52, 117, 300, 274, 862, 487, 715, 272, 232, 543, 275, 68, 144, 656, 623, 317, 63, 908, 565, 880, 12, 920, 467, 559, 91, 698});
        System.out.println("s.removeNodes(l) = " + s.removeNodes(l).toStrings());
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode p = head;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        while (p != null) {
            Integer value = tm.get(p.val);
            tm.put(p.val, (value == null ? 0 : value) + 1);
            p = p.next;
        }
        ListNode result = new ListNode();
        result.next = head;
        p = result;
        while (p != null && !tm.isEmpty()) {
            while (p.next != null && p.next.val != tm.lastKey()) {
                int value = tm.get(p.next.val);
                if (value == 1) {
                    tm.remove(p.next.val);
                } else {
                    tm.put(p.next.val, value - 1);
                }
                p.next = p.next.next;
            }
            p = p.next;
            int value = tm.get(tm.lastKey());
            if (value == 1) {
                tm.remove(tm.lastKey());
            } else {
                tm.put(tm.lastKey(), value - 1);
            }
        }
        return result.next;
    }
}
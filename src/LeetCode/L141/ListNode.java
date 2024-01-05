package LeetCode.L141;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int pos, int[] nums){
        if (nums.length == 0){
            return;
        }
        ListNode end = this;
        this.val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            end.next = new ListNode(nums[i]);
            end = end.next;
        }
        if (pos < 0){
            return;
        }
        ListNode p = this;
        while (pos > 0){
            assert p != null;
            p = p.next;
            pos--;
        }
        end.next = p;
    }
    static ListNode init(int[] p){
        int count = p.length;
        ListNode result = new ListNode(p[0]);
        ListNode px = result;
        int xp = 1;
        while (xp < count){
            px.next = new ListNode(p[xp]);
            px = px.next;
            xp++;
        }
        return result;
    }
}
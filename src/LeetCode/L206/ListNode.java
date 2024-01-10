package LeetCode.L206;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] p){
        this.val = p[0];
        int xp = 1;
        ListNode lp = this;
        while (xp < p.length){
            lp.next = new ListNode(p[xp]);
            lp = lp.next;
            xp++;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
    public String toStrings(){
        StringBuilder sb = new StringBuilder();
        ListNode s = this;
        while (s != null){
            sb.append(s.val).append(" ");
            s = s.next;
        }
        return sb.toString();
    }
}
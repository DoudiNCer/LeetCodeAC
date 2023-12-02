package LeetCode.L86;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
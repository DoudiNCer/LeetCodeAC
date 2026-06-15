use super::Solution;
use super::listnode::ListNode;

/*
    给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。

    长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。

    对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。

    提示：

    链表中节点的数目在范围 [1, 10^5] 内
    1 <= Node.val <= 10^5
*/

// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
//
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
impl Solution {
    pub fn delete_middle(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        if head.is_none() {
            return head;
        }
        let (mut n, mut cur) = (0, head.as_ref());
        while let Some(node) = cur {
            n += 1;
            cur = node.next.as_ref();
        }
        if n < 2 {
            return None;
        }
        let mut head = head;
        n = n >> 1;
        let mut cur = &mut head;
        for _ in 1..n {
            cur = &mut cur.as_mut().unwrap().next;
        }
        let k_node = cur.as_mut().unwrap().next.take();
        cur.as_mut().unwrap().next = k_node.unwrap().next;
        head
    }
}

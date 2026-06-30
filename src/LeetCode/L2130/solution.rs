use super::listnode::ListNode;
use super::Solution;

/*
    在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。

    比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
    孪生和 定义为一个节点和它孪生节点两者值之和。

    给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。

    提示：

    链表的节点数目是 [2, 10^5] 中的 偶数 。
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
    pub fn pair_sum(head: Option<Box<ListNode>>) -> i32 {
        let mut n = 0;
        let mut cur = head.as_ref();
        while let Some(node) = cur {
            n += 1;
            cur = node.next.as_ref();
        }
        cur = head.as_ref();
        let mut array = Vec::with_capacity(n >> 1);
        for _ in 0..(n >> 1) {
            if let Some(node) = cur {
                array.push(node.val);
                cur = node.next.as_ref();
            }
        }
        let mut res = 0;
        for i in 0..(n >> 1) {
            if let Some(node) = cur {
                res = res.max(array[(n >> 1) - 1 - i] + node.val);
                cur = node.next.as_ref();
            }
        }
        res
    }
}

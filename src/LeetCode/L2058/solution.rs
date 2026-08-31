use super::Solution;
use super::listnode::ListNode;
use std::process::id;

/*
    链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。

    如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。

    如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。

    注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。

    给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，其中 minDistance 是任意两个不同临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。

    提示：

    链表中节点的数量在范围 [2, 10^5] 内
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
    pub fn nodes_between_critical_points(head: Option<Box<ListNode>>) -> Vec<i32> {
        let mut res = vec![-1, -1];
        let mut last_idx = 0;
        let mut cur = head.as_ref();
        let mut idx = 1;
        while let Some(node) = cur {
            let nxt = node.next.as_ref();
            if let Some(nnode) = nxt {
                let nnxt = nnode.next.as_ref();
                if let Some(nnnode) = nnxt {
                    if nnode.val > nnnode.val && nnode.val > node.val
                        || nnode.val < nnnode.val && nnode.val < node.val
                    {
                        if last_idx != 0 {
                            if res[0] != -1 {
                                res[0] = res[0].min(idx - last_idx);
                                res[1] += (idx - last_idx);
                            } else {
                                res[0] = idx - last_idx;
                                res[1] = res[0];
                            }
                        }
                        last_idx = idx;
                    }
                    cur = nxt;
                    idx += 1;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        res
    }
}

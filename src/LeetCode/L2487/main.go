package main

/*
给你一个链表的头节点 head 。

移除每个右侧有一个更大数值的节点。

返回修改后链表的头节点 head 。

示例 1：

输入：head = [5,2,13,3,8]
输出：[13,8]
解释：需要移除的节点是 5 ，2 和 3 。
- 节点 13 在节点 5 右侧。
- 节点 13 在节点 2 右侧。
- 节点 8 在节点 3 右侧。
示例 2：

输入：head = [1,1,1,1]
输出：[1,1,1,1]
解释：每个节点的值都是 1 ，所以没有需要移除的节点。

提示：

- 给定列表中的节点数目在范围 [1, 10^5] 内
- 1 <= Node.val <= 10^5
*/
func main() {
	removeNodes(&ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 1,
			Next: &ListNode{
				Val:  1,
				Next: &ListNode{Val: 1},
			},
		},
	})
}

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNodes(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	rev := reverseList(head)

	max := rev.Val
	p := rev
	for p.Next != nil {
		if p.Next.Val < max {
			p.Next = p.Next.Next
		} else if p.Next.Val > max {
			max = p.Next.Val
			p = p.Next
		} else {
			p = p.Next
		}
	}
	return reverseList(rev)
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode = nil
	curr := head

	for curr != nil {
		nextTemp := curr.Next
		curr.Next = prev
		prev = curr
		curr = nextTemp
	}
	return prev
}

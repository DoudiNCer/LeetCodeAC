package main

import "fmt"

/*
*
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

示例 1：

输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：

输入：head = [0,1,2], k = 4
输出：[2,0,1]

提示：

- 链表中节点的数目在范围 [0, 500] 内
- -100 <= Node.val <= 100
- 0 <= k <= 2 * 10^9
*/
func main() {
	l0 := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val:  4,
					Next: &ListNode{Val: 5},
				},
			},
		},
	}
	fmt.Println("rotateRight(l0, 2) = ", rotateRight(l0, 2))
}

func rotateRight(head *ListNode, k int) *ListNode {
	if head == nil || head.Next == nil || k == 0 {
		return head
	}
	n := 1
	end := head
	for end.Next != nil {
		end = end.Next
		n++
	}
	k = k % n
	if k < 0 {
		k += n
	}
	if k == 0 {
		return head
	}
	k = n - k
	end.Next = head
	for k > 0 {
		k--
		end = end.Next
	}
	head = end.Next
	end.Next = nil
	return head
}

type ListNode struct {
	Val  int
	Next *ListNode
}

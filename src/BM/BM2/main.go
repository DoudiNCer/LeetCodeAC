package main

import "fmt"

/**
将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度O(n)，空间复杂度O(1)。
例如：
给出的链表为 1→2→3→4→5→NULL,m=2,n=4,
返回 1→4→3→2→5→NULL.

数据范围： 链表长度 0<size≤1000，0<m≤n≤size，链表中每个节点的值满足∣val∣≤1000
要求：时间复杂度O(n) ，空间复杂度O(n)
进阶：时间复杂度O(n)，空间复杂度O(1)
*/

func main() {
	head := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 3,
				Next: &ListNode{
					Val: 4,
					Next: &ListNode{
						Val: 5,
					},
				},
			},
		},
	}
	fmt.Println("reverseBetween(head, 2, 4) = ", reverseBetween(head, 2, 4))
}

func reverseBetween(head *ListNode, m int, n int) *ListNode {
	if m == n {
		return head
	}
	m--
	n -= m
	mHead := head
	for m > 0 {
		mHead = mHead.Next
		m--
	}
	nHead := mHead
	val := make([]int, n)
	for i := 0; i < n; i++ {
		val[i] = nHead.Val
		nHead = nHead.Next
	}
	nHead = mHead
	for i := 0; i < n; i++ {
		nHead.Val = val[n-i-1]
		nHead = nHead.Next
	}
	return head
}

type ListNode struct {
	Val  int
	Next *ListNode
}

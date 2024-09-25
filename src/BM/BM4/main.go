package main

import "fmt"

/*
*
输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
数据范围：0≤n≤1000，−1000≤节点值≤1000
要求：空间复杂度O(1)，时间复杂度O(n)

如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，转换过程如下图所示：

或输入{-1,2,4},{1,3,4}时，合并后的链表为{-1,1,2,3,4,4}，所以对应的输出为{-1,1,2,3,4,4}，转换过程如下图所示：
*/
func main() {
	ph1 := &ListNode{
		Val: 1,
		Next: &ListNode{
			Val: 3,
			Next: &ListNode{
				Val: 5,
			},
		},
	}
	ph2 := &ListNode{
		Val: 2,
		Next: &ListNode{
			Val: 4,
			Next: &ListNode{
				Val: 6,
			},
		},
	}
	fmt.Println("Merge(ph1, ph2) = ", Merge(ph1, ph2))
}

func Merge(pHead1 *ListNode, pHead2 *ListNode) *ListNode {
	if pHead1 == nil {
		return pHead2
	}
	if pHead2 == nil {
		return pHead1
	}
	var result *ListNode
	if pHead1.Val > pHead2.Val {
		result = pHead2
		pHead2 = pHead2.Next
	} else {
		result = pHead1
		pHead1 = pHead1.Next
	}
	p := result
	p.Next = nil
	for pHead1 != nil && pHead2 != nil {
		if pHead1.Val > pHead2.Val {
			p.Next = pHead2
			pHead2 = pHead2.Next
		} else {
			p.Next = pHead1
			pHead1 = pHead1.Next
		}
		p = p.Next
		p.Next = nil
	}
	if pHead1 != nil {
		p.Next = pHead1
	} else {
		p.Next = pHead2
	}
	return result
}

type ListNode struct {
	Val  int
	Next *ListNode
}

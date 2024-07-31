package main

import "fmt"

func main() {
	fmt.Println("reverseKGroup(sliceToListNode([]int{1, 2, 3, 4, 5}), 2) = ", reverseKGroup(sliceToListNode([]int{1, 2, 3, 4, 5}), 2))
}

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reverseKGroup(head *ListNode, k int) *ListNode {
	if k < 2 || head == nil || head.Next == nil {
		return head
	}
	var p, q *ListNode
	p = new(ListNode)
	p.Next = head
	q, head = p, p
	for {
		i := 0
		for i < k {
			if q.Next == nil {
				break
			}
			q = q.Next
			i++
		}
		if i < k {
			break
		}
		np := p.Next
		reverseListNode(p, q.Next)
		p, q = np, np
	}
	return head.Next
}

func reverseListNode(p, q *ListNode) {
	b := q
	m := p.Next
	e := m.Next
	for {
		m.Next = b
		if e == q {
			break
		}
		b = m
		m = e
		e = e.Next
	}
	p.Next = m
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func sliceToListNode(nums []int) *ListNode {
	if len(nums) == 0 {
		return nil
	}

	head := &ListNode{Val: nums[0]}
	current := head

	for _, num := range nums[1:] {
		current.Next = &ListNode{Val: num}
		current = current.Next
	}
	return head
}

package main

import "fmt"

/*
*
给定一个长度为 n 的链表 head

对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。

返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。

示例 1：

输入：head = [2,1,5]
输出：[5,5,0]
示例 2：

输入：head = [2,7,4,3,5]
输出：[7,0,5,5,0]

提示：

- 链表中节点数为 n
- 1 <= n <= 10^4
- 1 <= Node.val <= 10^9
*/
func main() {
	l0 := &ListNode{
		Val: 2,
		Next: &ListNode{
			Val:  1,
			Next: &ListNode{Val: 5},
		},
	}
	fmt.Println("nextLargerNodes(l0) = ", nextLargerNodes(l0))
}

type ListNode struct {
	Val  int
	Next *ListNode
}

type Node struct {
	val int
	idx int
}

func nextLargerNodes(head *ListNode) []int {
	if head == nil {
		return []int{}
	}
	res := make([]int, 0)
	stack := make([]Node, 0)
	for i, p := 0, head; p != nil; i, p = i+1, p.Next {
		res = append(res, 0)
		for len(stack) > 0 && stack[len(stack)-1].val < p.Val {
			res[stack[len(stack)-1].idx] = p.Val
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, Node{
			val: p.Val,
			idx: i,
		})
	}
	return res
}

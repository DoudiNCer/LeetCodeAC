package main

import "fmt"

/*
*
给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。

数据范围： 0 ≤ n ≤ 1000 0 ≤ n ≤ 1000
要求：空间复杂度 O(1)，时间复杂度O(n) 。

如当输入链表{1,2,3}时，
经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
以上转换过程如下图所示：

示例1
输入：
{1,2,3}
返回值：
{3,2,1}
示例2
输入：
{}
返回值：
{}
说明：
空链表则输出空
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
				},
			},
		},
	}
	fmt.Println("ReverseList(head) = ", ReverseList(head))
}

/**
 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
 *
 *
 * @param head ListNode类
 * @return ListNode类
 */
func ReverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	l, r := head, head.Next
	l.Next = nil
	for r != nil {
		p := r.Next
		r.Next = l
		l, r = r, p
	}
	return l
}

type ListNode struct {
	Val  int
	Next *ListNode
}

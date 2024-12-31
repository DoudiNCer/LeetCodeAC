package main

/*
*
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

示例 1：

输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：

输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]

提示：

- 链表中节点的数目在范围 [0, 5 * 10^4] 内
- -10^5 <= Node.val <= 10^5
*/
func main() {
	list := &ListNode{
		Val: 4,
		Next: &ListNode{
			Val: 2,
			Next: &ListNode{
				Val: 1,
				Next: &ListNode{
					Val:  3,
					Next: nil,
				},
			},
		},
	}
	list = sortList(list)
}

func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	mid := getMiddle(head)
	l, r := head, mid.Next
	mid.Next = nil
	l = sortList(l)
	r = sortList(r)
	return merge(l, r)
}

func getMiddle(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	fast, slow := head, head
	for fast.Next != nil && fast.Next.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
	}
	return slow
}

func merge(l, r *ListNode) *ListNode {
	result := &ListNode{}
	tmp := result
	for l != nil && r != nil {
		if l.Val < r.Val {
			tmp.Next = l
			l = l.Next
		} else {
			tmp.Next = r
			r = r.Next
		}
		tmp = tmp.Next
	}
	if l != nil {
		tmp.Next = l
	} else if r != nil {
		tmp.Next = r
	}
	return result.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}

package main

import "fmt"

func main() {
	t0 := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val:   2,
			Left:  &TreeNode{Val: 4},
			Right: &TreeNode{Val: 5},
		},
		Right: &TreeNode{
			Val:   3,
			Left:  &TreeNode{Val: 6},
			Right: &TreeNode{Val: 7},
		},
	}
	fmt.Println("delNodes(t0, []int{3, 5}) = ")
	for _, node := range delNodes(t0, []int{3, 5}) {
		fmt.Println("node = ", node)
	}
}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func delNodes(root *TreeNode, to_delete []int) []*TreeNode {
	deleteMap := make(map[int]any, len(to_delete))
	for _, d := range to_delete {
		deleteMap[d] = struct{}{}
	}
	if root != nil {
		_, exist := deleteMap[root.Val]
		return deleteNodes(root, deleteMap, true, exist)
	} else {
		return []*TreeNode{}
	}
}

func deleteNodes(node *TreeNode, deleteMap map[int]any, orphan, kill bool) []*TreeNode {
	result := []*TreeNode{}
	if node.Left != nil {
		_, exist := deleteMap[node.Left.Val]
		result = append(result, deleteNodes(node.Left, deleteMap, kill, exist)...)
		if exist {
			node.Left = nil
		}
	}
	if node.Right != nil {
		_, exist := deleteMap[node.Right.Val]
		result = append(result, deleteNodes(node.Right, deleteMap, kill, exist)...)
		if exist {
			node.Right = nil
		}
	}
	if orphan && !kill {
		result = append(result, node)
	}
	return result
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

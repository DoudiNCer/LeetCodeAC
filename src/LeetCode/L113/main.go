package main

import "fmt"

/*
*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。

示例 1：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]
示例 2：

输入：root = [1,2,3], targetSum = 5
输出：[]
示例 3：

输入：root = [1,2], targetSum = 0
输出：[]

提示：

- 树中节点总数在范围 [0, 5000] 内
- -1000 <= Node.val <= 1000
- -1000 <= targetSum <= 1000
*/
func main() {
	t0 := &TreeNode{
		Val: 5,
		Left: &TreeNode{Val: 4, Left: &TreeNode{
			Val:   11,
			Left:  &TreeNode{Val: 7},
			Right: &TreeNode{Val: 2},
		}},
		Right: &TreeNode{Val: 8, Left: &TreeNode{Val: 13}, Right: &TreeNode{
			Val:   4,
			Left:  &TreeNode{Val: 5},
			Right: &TreeNode{Val: 1},
		}},
	}
	fmt.Println("pathSum(t0, 22) = ", pathSum(t0, 22))
}

func pathSum(root *TreeNode, targetSum int) [][]int {
	var (
		result   = make([][]int, 0)
		stack    = make([]int, 0)
		stackSum = 0
	)
	if root == nil {
		return result
	}
	var check func(root *TreeNode)
	check = func(root *TreeNode) {
		if root == nil {
			return
		}
		stackSum += root.Val
		stack = append(stack, root.Val)
		if root.Left == nil && root.Right == nil {
			if stackSum == targetSum {
				result = append(result, copySlice(stack))
			}
		} else {
			if root.Left != nil {
				check(root.Left)
			}
			if root.Right != nil {
				check(root.Right)
			}
		}
		stack = stack[:len(stack)-1]
		stackSum -= root.Val
	}
	check(root)
	return result
}

func copySlice(src []int) []int {
	result := make([]int, len(src))
	for i, v := range src {
		result[i] = v
	}
	return result
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

package main

import "fmt"

/*
*
给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

示例 1：

输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
输出：3
解释：和等于 8 的路径有 3 条，如图所示。
示例 2：

输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：3

提示:

- 二叉树的节点个数的范围是 [0,1000]
- -109 <= Node.val <= 109
- -1000 <= targetSum <= 1000
*/
func main() {
	t0 := &TreeNode{
		Val: 10,
		Left: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val:   3,
				Left:  &TreeNode{Val: 3},
				Right: &TreeNode{Val: -2},
			},
			Right: &TreeNode{
				Val:   2,
				Right: &TreeNode{Val: 1},
			},
		},
		Right: &TreeNode{
			Val:   -3,
			Right: &TreeNode{Val: 11},
		},
	}
	fmt.Println("pathSum(t0, 8) = ", pathSum(t0, 8))
}

func pathSum(root *TreeNode, targetSum int) int {
	var (
		result = 0
		stack  = make([]int, 0)
		sum    = 0
	)
	if root == nil {
		return 0
	}
	var scan func(root *TreeNode)
	scan = func(root *TreeNode) {
		if root == nil {
			return
		}
		sum += root.Val
		for _, s := range stack {
			if sum-s == targetSum {
				result++
			}
		}
		if sum == targetSum {
			result++
		}
		stack = append(stack, sum)
		if root.Left != nil {
			scan(root.Left)
		}
		if root.Right != nil {
			scan(root.Right)
		}
		stack = stack[:len(stack)-1]
		sum -= root.Val
	}
	scan(root)
	return result
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。

回想一下：

叶节点 是二叉树中没有子节点的节点
树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。

示例 1：

输入：root = [3,5,1,6,2,0,8,null,null,7,4]
输出：[2,7,4]
解释：我们返回值为 2 的节点，在图中用黄色标记。
在图中用蓝色标记的是树的最深的节点。
注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
示例 2：

输入：root = [1]
输出：[1]
解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
示例 3：

输入：root = [0,1,3,null,2]
输出：[2]
解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。

提示：

- 树中的节点数将在 [1, 1000] 的范围内。
- 0 <= Node.val <= 1000
每个节点的值都是 独一无二 的。
*/
func main() {
	t0 := &TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val:  5,
			Left: &TreeNode{Val: 6},
			Right: &TreeNode{
				Val:   2,
				Left:  &TreeNode{Val: 7},
				Right: &TreeNode{Val: 4},
			},
		},
		Right: &TreeNode{
			Val:   1,
			Left:  &TreeNode{Val: 0},
			Right: &TreeNode{Val: 8},
		},
	}
	fmt.Println("lcaDeepestLeaves(t0).Val = ", lcaDeepestLeaves(t0).Val)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func lcaDeepestLeaves(root *TreeNode) *TreeNode {
	if root == nil || root.Left == nil && root.Right == nil {
		return root
	}
	ml, trace := 1, [][]*TreeNode{{root}}
	stack := []*TreeNode{}
	var dfs func(root *TreeNode, depth int)
	dfs = func(root *TreeNode, depth int) {
		stack = append(stack, root)
		defer func() {
			stack = stack[:len(stack)-1]
		}()
		if root.Left == nil && root.Right == nil {
			if depth < ml {
				return
			}
			st := make([]*TreeNode, len(stack))
			copy(st, stack)
			if depth > ml {
				ml = depth
				trace = [][]*TreeNode{}
			}
			trace = append(trace, st)
			return
		}
		if root.Left != nil {
			dfs(root.Left, depth+1)
		}
		if root.Right != nil {
			dfs(root.Right, depth+1)
		}
	}
	dfs(root, 1)
	if len(trace) == 1 {
		return trace[0][len(trace[0])-1]
	}
	r := sort.Search(ml, func(i int) bool {
		t0 := trace[0][i].Val
		for x := 1; x < len(trace); x++ {
			if trace[x][i].Val != t0 {
				return true
			}
		}
		return false
	})
	return trace[0][r-1]
}

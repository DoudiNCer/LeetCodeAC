package main

import (
	"fmt"
)

/*
*
我们从二叉树的根节点 root 开始进行深度优先搜索。

在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。

如果节点只有一个子节点，那么保证该子节点为左子节点。

给出遍历输出 S，还原树并返回其根节点 root。

示例 1：

输入："1-2--3--4-5--6--7"
输出：[1,2,5,3,4,6,7]
示例 2：

输入："1-2--3---4-5--6---7"
输出：[1,2,5,3,null,6,null,4,null,7]
示例 3：

输入："1-401--349---90--88"
输出：[1,401,null,349,88,90]

提示：

- 原始树中的节点数介于 1 和 1000 之间。
- 每个节点的值介于 1 和 10 ^ 9 之间。
*/
func main() {
	fmt.Println("recoverFromPreorder(\"1-2--3--4-5--6--7\") = ",
		recoverFromPreorder("1-2--3--4-5--6--7"))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func recoverFromPreorder(S string) *TreeNode {
	ans := map[int]*TreeNode{-1: {}}
	addTree := func(v, p int) {
		ans[p] = &TreeNode{Val: v}
		if _, exist := ans[p-1]; exist {
			if ans[p-1].Left == nil {
				ans[p-1].Left = ans[p]
			} else {
				ans[p-1].Right = ans[p]
			}
		}
	}
	p, le := 0, len(S)
	for {
		if p == le {
			break
		}
		dep := 0
		for S[p] == '-' {
			p++
			dep++
		}
		size := 0
		for p < le && S[p] != '-' {
			size *= 10
			size += int(S[p] - '0')
			p++
		}
		addTree(size, dep)
	}
	fmt.Println(ans)
	return ans[0]
}

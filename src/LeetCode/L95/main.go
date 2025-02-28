package main

import (
	"fmt"
)

/*
*
给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。

示例 1：

输入：n = 3
输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
示例 2：

输入：n = 1
输出：[[1]]

提示：

- 1 <= n <= 8
*/
func main() {
	fmt.Println("generateTrees(1) = ", generateTrees(1))
	fmt.Println("generateTrees(3) = ", generateTrees(3))
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var table = map[int]map[int][]*TreeNode{}

func generateTrees(n int) []*TreeNode {
	for i := 1; i <= n; i++ {
		if _, ok := table[i]; !ok {
			table[i] = make(map[int][]*TreeNode)
			table[i][i] = []*TreeNode{{i, nil, nil}}
		}
	}
	return generateTreesByLR(1, n)
}

func generateTreesByLR(l, r int) []*TreeNode {
	if res, ok := table[l][r]; ok {
		return res
	}
	result := []*TreeNode{}
	for i := l; i <= r; i++ {
		var lres, rres []*TreeNode
		if i == l {
			lres = append(lres, nil)
		} else {
			lres = generateTreesByLR(l, i-1)
		}
		if i == r {
			rres = append(rres, nil)
		} else {
			rres = generateTreesByLR(i+1, r)
		}
		for _, lp := range lres {
			for _, rp := range rres {
				result = append(result, &TreeNode{i, lp, rp})
			}
		}
	}
	return result
}

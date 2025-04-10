package main

import "fmt"

/*
*
给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

示例 1：

输入：n = 3
输出：5
示例 2：

输入：n = 1
输出：1

提示：

- 1 <= n <= 19
*/
func main() {
	fmt.Println("numTrees(1) = ", numTrees(1))
	fmt.Println("numTrees(3) = ", numTrees(3))
}

var table = map[int]int{
	0: 1,
	1: 1,
}

func numTrees(n int) int {
	if cnt, ok := table[n]; ok {
		return cnt
	}
	result := 0
	for i := 0; i < n; i++ {
		result += numTrees(i) * numTrees(n-1-i)
	}
	table[n] = result
	return result
}

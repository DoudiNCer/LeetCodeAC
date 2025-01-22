package main

import "fmt"

/*
*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。

示例 1：

输入：n = 4, k = 2
输出：
[

	[2,4],
	[3,4],
	[2,3],
	[1,2],
	[1,3],
	[1,4],

]
示例 2：

输入：n = 1, k = 1
输出：[[1]]

提示：

- 1 <= n <= 20
- 1 <= k <= n
*/
func main() {
	fmt.Println("combine(4, 2) = ", combine(4, 2))
}

func combine(n int, k int) [][]int {
	result := make([][]int, 0)
	path := make([]int, k)
	var bt func(int2 int)
	bt = func(start int) {
		le := len(path)
		if le == k {
			tmp := make([]int, k)
			copy(tmp, path)
			result = append(result, tmp)
			return
		}
		for i := start; i <= n-k+le+1; i++ {
			path = append(path, i)
			bt(i + 1)
			path = path[:len(path)-1]
		}
	}
	bt(1)
	return result
}

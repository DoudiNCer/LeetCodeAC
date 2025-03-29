package main

import "fmt"

/*
*
给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，其中每个节点 至多 有一条出边。

图用一个大小为 n 下标从 0 开始的数组 edges 表示，节点 i 到节点 edges[i] 之间有一条有向边。如果节点 i 没有出边，那么 edges[i] == -1 。

请你返回图中的 最长 环，如果没有任何环，请返回 -1 。

一个环指的是起点和终点是 同一个 节点的路径。

示例 1：

输入：edges = [3,3,4,2,3]
输出去：3
解释：图中的最长环是：2 -> 4 -> 3 -> 2 。
这个环的长度为 3 ，所以返回 3 。
示例 2：

输入：edges = [2,-1,3,1]
输出：-1
解释：图中没有任何环。

提示：

- n == edges.length
- 2 <= n <= 10^5
- -1 <= edges[i] < n
- edges[i] != i
*/
func main() {
	fmt.Println("longestCycle([]int{3, 3, 4, 2, 3}) = ", longestCycle([]int{3, 3, 4, 2, 3}))
	fmt.Println("longestCycle([]int{2, -1, 3, 1}) = ", longestCycle([]int{2, -1, 3, 1}))
}

func longestCycle(edges []int) int {
	res := -1
	n := len(edges)
	checked := make([]bool, n)
	for x := 0; x < n; x++ {
		if checked[x] {
			continue
		}
		road := make(map[int]int)
		r := 0
		var dfs func(x int) (int, bool)
		dfs = func(x int) (int, bool) {
			if r0, ok := road[x]; ok {
				return r - r0, true
			}
			road[x] = r
			r++
			if checked[x] {
				return 0, false
			}
			checked[x] = true
			if edges[x] == -1 {
				return 0, false
			}
			return dfs(edges[x])
		}
		sz, ok := dfs(x)
		if ok && sz > res {
			res = sz
		}
	}
	return res
}

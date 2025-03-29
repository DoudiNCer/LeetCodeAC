package main

import (
	"container/heap"
	"fmt"
	"sort"
)

/*
*
给你一个大小为 m x n 的整数矩阵 grid 和一个大小为 k 的数组 queries 。

找出一个大小为 k 的数组 answer ，且满足对于每个整数 queries[i] ，你从矩阵 左上角 单元格开始，重复以下过程：

如果 queries[i] 严格 大于你当前所处位置单元格，如果该单元格是第一次访问，则获得 1 分，并且你可以移动到所有 4 个方向（上、下、左、右）上任一 相邻 单元格。
否则，你不能获得任何分，并且结束这一过程。
在过程结束后，answer[i] 是你可以获得的最大分数。注意，对于每个查询，你可以访问同一个单元格 多次 。

返回结果数组 answer 。

示例 1：

输入：grid = [[1,2,3],[2,5,7],[3,5,1]], queries = [5,6,2]
输出：[5,8,1]
解释：上图展示了每个查询中访问并获得分数的单元格。
示例 2：

输入：grid = [[5,2,1],[1,1,2]], queries = [3]
输出：[0]
解释：无法获得分数，因为左上角单元格的值大于等于 3 。

提示：

- m == grid.length
- n == grid[i].length
- 2 <= m, n <= 1000
- 4 <= m * n <= 10^5
- k == queries.length
- 1 <= k <= 10^4
- 1 <= grid[i][j], queries[i] <= 10^6
*/
func main() {
	fmt.Println("maxPoints([][]int{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, []int{5, 6, 2}) = ",
		maxPoints([][]int{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, []int{5, 6, 2}))
	fmt.Println("maxPoints([][]int{{5, 2, 1}, {1, 1, 2}}, []int{3}) = ", maxPoints([][]int{{5, 2, 1}, {1, 1, 2}}, []int{3}))
}

func maxPoints(grid [][]int, queries []int) []int {
	df := [][]int{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}
	k := len(queries)
	ans := make([]int, k)
	ps := make([]int, k)
	for i := range ps {
		ps[i] = i
	}
	sort.Slice(ps, func(i, j int) bool {
		return queries[ps[i]] < queries[ps[j]]
	})
	m, n := len(grid), len(grid[0])
	idx := func(i, j int) int {
		return i*n + j
	}
	uidx := func(id int) (i, j int) {
		return id / n, id % n
	}
	cnt := 0
	visited := make([]bool, m*n)
	visited[idx(0, 0)] = true
	mh := &MinHeap{}
	heap.Init(mh)
	heap.Push(mh, []int{grid[0][0], idx(0, 0)})
	for x := 0; x < k; x++ {
		que := queries[ps[x]]
		for mh.Len() > 0 && (*mh)[0][0] < que {
			cur := heap.Pop(mh).([]int)
			i, j := uidx(cur[1])
			cnt++
			for d := range df {
				i, j := i+df[d][0], j+df[d][1]
				if i < 0 || i >= m || j < 0 || j >= n || visited[idx(i, j)] {
					continue
				}
				heap.Push(mh, []int{grid[i][j], idx(i, j)})
				visited[idx(i, j)] = true
			}
		}
		ans[ps[x]] = cnt
	}
	return ans
}

type MinHeap [][]int

func (h MinHeap) Len() int {
	return len(h)
}

func (h MinHeap) Less(i, j int) bool {
	return h[i][0] < h[j][0]
}

func (h MinHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}

func (h *MinHeap) Push(x interface{}) {
	*h = append(*h, x.([]int))
}

func (h *MinHeap) Pop() interface{} {
	mi := (*h)[len(*h)-1]
	*h = (*h)[:len(*h)-1]
	return mi
}

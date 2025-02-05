package main

import (
	"fmt"
	"sort"
)

/*
*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。

示例 1：

输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2：

输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。

提示：

- 1 <= intervals.length <= 10^4
- intervals[i].length == 2
- 0 <= starti <= endi <= 10^4
*/
func main() {
	fmt.Println("merge([][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}) = ", merge([][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
	fmt.Println("merge([][]int{{1, 4}, {4, 5}}) = ", merge([][]int{{1, 4}, {4, 5}}))
}

func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0] || intervals[i][0] == intervals[j][0] && intervals[j][1] < intervals[j][1]
	})
	result := make([][]int, 0)
	start, end := intervals[0][0], intervals[0][1]
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] <= end {
			end = max(end, intervals[i][1])
		} else {
			result = append(result, []int{start, end})
			start, end = intervals[i][0], intervals[i][1]
		}
	}
	result = append(result, []int{start, end})
	return result
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

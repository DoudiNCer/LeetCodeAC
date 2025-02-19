package main

import (
	"fmt"
	"sort"
)

/*
给定 m 个数组，每个数组都已经按照升序排好序了。

现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。

返回最大距离。

示例 1：

输入：[[1,2,3],[4,5],[1,2,3]]
输出：4
解释：
一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
示例 2：

输入：arrays = [[1],[1]]
输出：0


提示：

- m == arrays.length
- 2 <= m <= 10^5
- 1 <= arrays[i].length <= 500
- -10^4 <= arrays[i][j] <= 10^4
- arrays[i] 以 升序 排序。
- 所有数组中最多有 10^5 个整数。
*/

func main() {
	fmt.Println("maxDistance([][]int{{1, 2, 3}, {4, 5}, {1, 2, 3}}) = ", maxDistance([][]int{{1, 2, 3}, {4, 5}, {1, 2, 3}}))
	fmt.Println("maxDistance([][]int{{1}, {1}}) = ", maxDistance([][]int{{1}, {1}}))
}

func maxDistance(arrays [][]int) int {
	m := len(arrays)
	maxs := make([]int, 0, m)
	for i := range arrays {
		maxs = append(maxs, arrays[i][len(arrays[i])-1])
	}
	sort.Ints(maxs)
	result := -1
	for i := range arrays {
		ma := -1
		if len(arrays[i]) == 1 {
			ma = maxs[m-1] - arrays[i][0]
		} else {
			if maxs[m-1] == arrays[i][len(arrays[i])-1] {
				ma = maxs[m-2] - arrays[i][0]
			} else {
				ma = maxs[m-1] - arrays[i][0]
			}
		}
		if ma < 0 {
			ma = -ma
		}
		if ma > result {
			result = ma
		}
	}
	return result
}

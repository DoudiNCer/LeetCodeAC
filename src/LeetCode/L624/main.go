package main

import (
	"fmt"
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
}

func maxDistance(arrays [][]int) int {
	minl, maxl := []int{0}, []int{0}
	for i, array := range arrays {
		ap := len(array) - 1
		if i == 0 {
			continue
		} else if i == 1 {
			minl = append(minl, 1)
			maxl = append(maxl, 1)
		} else {
			if array[0] < arrays[minl[1]][0] {
				minl[1] = i
			}
			if array[ap] > arrays[maxl[1]][0] {
				maxl[1] = i
			}
		}
		if arrays[minl[1]][0] < arrays[minl[0]][0] {
			minl[0], minl[1] = minl[1], minl[0]
		}
		if arrays[maxl[1]][len(arrays[maxl[1]])-1] > arrays[maxl[0]][len(arrays[maxl[0]])-1] {
			maxl[0], maxl[1] = maxl[1], maxl[0]
		}
	}
	if maxl[0] != minl[0] {
		return arrays[maxl[0]][len(arrays[maxl[0]])-1] - arrays[minl[0]][0]
	} else {
		a, b := arrays[maxl[0]][len(arrays[maxl[0]])-1]-arrays[minl[1]][0], arrays[maxl[1]][len(arrays[maxl[1]])-1]-arrays[minl[0]][0]
		if a > b {
			return a
		} else {
			return b
		}
	}
}

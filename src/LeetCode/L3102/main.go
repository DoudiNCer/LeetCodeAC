package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。

两点之间的距离定义为它们的曼哈顿距离。

请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。

示例 1：

输入：points = [[3,10],[5,15],[10,2],[4,4]]
输出：12
解释：移除每个点后的最大距离如下所示：
- 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
- 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
- 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
- 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
示例 2：

输入：points = [[1,1],[1,1],[1,1]]
输出：0
解释：移除任一点后，任意两点之间的最大距离都是 0 。

提示：

- 3 <= points.length <= 10^5
- points[i].length == 2
- 1 <= points[i][0], points[i][1] <= 10^8
*/
func main() {
	fmt.Println("minimumDistance([][]int{{3, 10}, {5, 15}, {10, 2}, {4, 4}}) = ",
		minimumDistance([][]int{{3, 10}, {5, 15}, {10, 2}, {4, 4}}))
	fmt.Println("minimumDistance([][]int{{7, 9}, {1, 10}, {6, 10}, {7, 3}, {9, 2}, {9, 10}, {7, 10}, {10, 4}, {4, 10}, {5, 4}}) = ",
		minimumDistance([][]int{{7, 9}, {1, 10}, {6, 10}, {7, 3}, {9, 2}, {9, 10}, {7, 10}, {10, 4}, {4, 10}, {5, 4}}))
}

func minimumDistance(points [][]int) int {
	sumset, diffset := make(map[int]int), make(map[int]int)
	for i := range points {
		sum, diff := points[i][0]+points[i][1], points[i][0]-points[i][1]
		sumset[sum]++
		diffset[diff]++
	}
	sumlist, difflist := make([]int, 0, len(sumset)), make([]int, 0, len(diffset))
	for sum := range sumset {
		sumlist = append(sumlist, sum)
	}
	for diff := range diffset {
		difflist = append(difflist, diff)
	}
	sort.Ints(sumlist)
	sort.Ints(difflist)
	res := max(sumlist[len(sumlist)-1]-sumlist[0], difflist[len(difflist)-1]-difflist[0])
	for i := range points {
		sum, diff := points[i][0]+points[i][1], points[i][0]-points[i][1]
		if sum > sumlist[0] && diff > difflist[0] && sum < sumlist[len(sumlist)-1] && diff < difflist[len(difflist)-1] {
			continue
		}
		if sumset[sum] > 1 && diffset[diff] > 1 {
			continue
		}
		sum0 := sumlist[0]
		sumn := sumlist[len(sumlist)-1]
		if sum0 == sum && sumset[sum] == 1 {
			sum0 = sumlist[1]
		} else if sumn == sum && sumset[sum] == 1 {
			sumn = sumlist[len(sumlist)-2]
		}
		diff0 := difflist[0]
		diffn := difflist[len(difflist)-1]
		if diff0 == diff && diffset[diff] == 1 {
			diff0 = difflist[1]
		} else if diffn == diff && diffset[diff] == 1 {
			diffn = difflist[len(difflist)-2]
		}
		res = min(res, max(sumn-sum0, diffn-diff0))
	}
	return res
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

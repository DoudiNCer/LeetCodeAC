package main

import (
	"fmt"
)

/*
*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

示例 1:

输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
示例 2：

输入： heights = [2,4]
输出： 4

提示：

- 1 <= heights.length <=10^5
- 0 <= heights[i] <= 10^4
*/
func main() {
	fmt.Println("largestRectangleArea([]int{2, 1, 5, 6, 2, 3}) = ",
		largestRectangleArea([]int{2, 1, 5, 6, 2, 3}))
}

func largestRectangleArea(heights []int) int {
	le := len(heights)
	ledge, redge := make([]int, le), make([]int, le)
	mono_stack := []int{}
	for i := 0; i < le; i++ {
		redge[i] = le
		p := len(mono_stack) - 1
		for p >= 0 && heights[mono_stack[p]] >= heights[i] {
			redge[mono_stack[p]] = i
			p--
		}
		mono_stack = mono_stack[:p+1]
		if p == -1 {
			ledge[i] = -1
		} else {
			ledge[i] = mono_stack[p]
		}
		mono_stack = append(mono_stack, i)
	}
	result := heights[0]
	for i := 0; i < le; i++ {
		result = max(result, heights[i]*(redge[i]-ledge[i]-1))
	}
	return result
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}

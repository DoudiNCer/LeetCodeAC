package main

import "fmt"

/*
*
给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例 1：

输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：6
解释：最大矩形如上图所示。
示例 2：

输入：matrix = [["0"]]
输出：0
示例 3：

输入：matrix = [["1"]]
输出：1

提示：

- rows == matrix.length
- cols == matrix[0].length
- 1 <= row, cols <= 200
- matrix[i][j] 为 '0' 或 '1'
*/
func main() {
	fmt.Println("maximalRectangle([][]byte{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}) = ",
		maximalRectangle([][]byte{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}))
	fmt.Println("maximalRectangle([][]byte{{'1'}}) = ", maximalRectangle([][]byte{{'1'}}))
	fmt.Println("maximalRectangle([][]byte{{'1', '1', '0', '1'}}) = ", maximalRectangle([][]byte{{'1', '1', '0', '1'}}))
	fmt.Println("maximalRectangle([][]byte{{'1'}, {'1'}, {'0'}, {'1'}}) = ", maximalRectangle([][]byte{{'1'}, {'1'}, {'0'}, {'1'}}))
}

func maximalRectangle(matrix [][]byte) int {
	m, n := len(matrix), len(matrix[0])
	heights := make([][]int, m)
	for i := 0; i < m; i++ {
		heights[i] = make([]int, n+1)
	}
	for j := 0; j < n; j++ {
		cnt := 0
		for i := 0; i < m; i++ {
			if matrix[i][j] == '0' {
				if cnt == 0 {
					continue
				}
				heights[i-cnt][n] = 1
				for cnt > 0 {
					heights[i-cnt][j] = cnt
					cnt--
				}
			} else {
				cnt++
			}
		}
		i := m
		if matrix[i-1][j] == '1' {
			heights[i-cnt][n] = 1
			for cnt > 0 {
				heights[i-cnt][j] = cnt
				cnt--
			}
		}
	}
	result := 0
	for i := 0; i < m; i++ {
		if heights[i][n] == 0 {
			continue
		}
		result = max(result, largestRectangleArea(heights[i][:n]))
	}
	return result
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

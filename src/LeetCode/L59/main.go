package main

import "fmt"

/*
*
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

示例 1：

输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：

输入：n = 1
输出：[[1]]

提示：

- 1 <= n <= 20
*/
func main() {
	fmt.Println("generateMatrix(1) = ", generateMatrix(1))
	fmt.Println("generateMatrix(3) = ", generateMatrix(3))
}

func generateMatrix(n int) [][]int {
	result := make([][]int, 0, n)
	for i := 0; i < n; i++ {
		result = append(result, make([]int, n))
	}
	for i, loc := range matrixSpiralOrder(n, n) {
		result[loc[0]][loc[1]] = i + 1
	}
	return result
}

func matrixSpiralOrder(m, n int) [][]int {
	if m*n == 0 {
		return [][]int{}
	}
	result := make([][]int, 0, m*n)
	u, d, l, r := 0, m-1, 0, n-1
	for l <= r && u <= d {
		for j := l; j <= r; j++ {
			result = append(result, []int{u, j})
		}
		u++
		for i := u; i <= d; i++ {
			result = append(result, []int{i, r})
		}
		r--
		if u <= d {
			for j := r; j >= l; j-- {
				result = append(result, []int{d, j})
			}
			d--
		}
		if l <= r {
			for i := d; i >= u; i-- {
				result = append(result, []int{i, l})
			}
			l++
		}
	}
	return result
}

package main

import "fmt"

/*
*
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：`

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：

- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 10
- -100 <= matrix[i][j] <= 100
*/
func main() {
	fmt.Println("spiralOrder([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}) = ",
		spiralOrder([][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}))
}

func spiralOrder(matrix [][]int) []int {
	m, n := len(matrix), len(matrix[0])
	result := make([]int, 0, m*n)
	u, d, l, r := 0, m-1, 0, n-1
	for l <= r && u <= d {
		for j := l; j <= r; j++ {
			result = append(result, matrix[u][j])
		}
		u++
		for i := u; i <= d; i++ {
			result = append(result, matrix[i][r])
		}
		r--
		if u <= d {
			for j := r; j >= l; j-- {
				result = append(result, matrix[d][j])
			}
			d--
		}
		if l <= r {
			for i := d; i >= u; i-- {
				result = append(result, matrix[i][l])
			}
			l++
		}
	}
	return result
}

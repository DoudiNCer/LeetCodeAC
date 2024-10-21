package main

import "fmt"

/*
*
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

示例 1：

输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：4
示例 2：

输入：matrix = [["0","1"],["1","0"]]
输出：1
示例 3：

输入：matrix = [["0"]]
输出：0

提示：

- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 300
- matrix[i][j] 为 '0' 或 '1'
*/
func main() {
	fmt.Println("maximalSquare([][]byte{{'1', '0', '1', '0', '0'}, \n\t\t{'1', '0', '1', '1', '1'}, \n\t\t{'1', '1', '1', '1', '1'}, \n\t\t{'1', '0', '0', '1', '0'}}) = ",
		maximalSquare([][]byte{{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'}}))
}

func maximalSquare(matrix [][]byte) int {
	m, n := len(matrix), len(matrix[0])
	dp := make([][]int, m)
	maxL := 0
	dp[0] = make([]int, n)
	for j := 0; j < n; j++ {
		dp[0][j] = int(matrix[0][j] - '0')
		maxL = max(maxL, dp[0][j])
	}
	for i := 1; i < m; i++ {
		dp[i] = make([]int, n)
		dp[i][0] = int(matrix[i][0] - '0')
		maxL = max(maxL, dp[i][0])
		for j := 1; j < n; j++ {
			if matrix[i][j] == '0' {
				dp[i][j] = 0
			} else {
				dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
				maxL = max(maxL, dp[i][j])
			}
		}
	}
	return maxL * maxL
}

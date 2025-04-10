package main

import "fmt"

/*
*
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例 1：

输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
示例 2：

输入：grid = [[1,2,3],[4,5,6]]
输出：12

提示：

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 200
- 0 <= grid[i][j] <= 200
*/
func main() {
	fmt.Println("minPathSum([][]int{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}) = ",
		minPathSum([][]int{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}))
}

func minPathSum(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	dp := make([][]int, 2)
	dp[0] = make([]int, n)
	dp[0][0] = grid[0][0]
	for j := 1; j < n; j++ {
		dp[0][j] = dp[0][j-1] + grid[0][j]
	}
	for i := 1; i < m; i++ {
		dp[1] = make([]int, n)
		dp[1][0] = grid[i][0] + dp[0][0]
		for j := 1; j < n; j++ {
			dp[1][j] = minInt(dp[1][j-1], dp[0][j]) + grid[i][j]
		}
		dp[0] = dp[1]
	}
	return dp[0][n-1]
}

func minInt(a, b int) int {
	if a < b {
		return a
	}
	return b
}

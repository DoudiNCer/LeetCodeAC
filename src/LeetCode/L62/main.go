package main

import "fmt"

/*
*
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

问总共有多少条不同的路径？

示例 1：

输入：m = 3, n = 7
输出：28
示例 2：

输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下
示例 3：

输入：m = 7, n = 3
输出：28
示例 4：

输入：m = 3, n = 3
输出：6

提示：

- 1 <= m, n <= 100
- 题目数据保证答案小于等于 2 * 10^9
*/
func main() {
	fmt.Println("uniquePaths(3, 7) = ", uniquePaths(3, 7))
	fmt.Println("uniquePaths(3, 2) = ", uniquePaths(3, 2))
}

func uniquePaths(m int, n int) int {
	if m > n {
		m, n = n, m
	}
	dp := make([][]int, 2)
	dp[0] = make([]int, n)
	for j := 0; j < n; j++ {
		dp[0][j] = 1
	}
	for i := 1; i < m; i++ {
		dp[1] = make([]int, n)
		dp[1][0] = 1
		for j := 1; j < n; j++ {
			dp[1][j] = dp[0][j] + dp[1][j-1]
		}
		dp[0] = dp[1]
	}
	return dp[0][n-1]
}

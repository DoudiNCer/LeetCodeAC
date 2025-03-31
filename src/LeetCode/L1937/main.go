package main

import "fmt"

/*
*
给你一个 m x n 的整数矩阵 points （下标从 0 开始）。一开始你的得分为 0 ，你想最大化从矩阵中得到的分数。

你的得分方式为：每一行 中选取一个格子，选中坐标为 (r, c) 的格子会给你的总得分 增加 points[r][c] 。

然而，相邻行之间被选中的格子如果隔得太远，你会失去一些得分。对于相邻行 r 和 r + 1 （其中 0 <= r < m - 1），选中坐标为 (r, c1) 和 (r + 1, c2) 的格子，你的总得分 减少 abs(c1 - c2) 。

请你返回你能得到的 最大 得分。

abs(x) 定义为：

如果 x >= 0 ，那么值为 x 。
如果 x < 0 ，那么值为 -x 。

示例 1：

输入：points = [[1,2,3],[1,5,1],[3,1,1]]
输出：9
解释：
蓝色格子是最优方案选中的格子，坐标分别为 (0, 2)，(1, 1) 和 (2, 0) 。
你的总得分增加 3 + 5 + 3 = 11 。
但是你的总得分需要扣除 abs(2 - 1) + abs(1 - 0) = 2 。
你的最终得分为 11 - 2 = 9 。
示例 2：

输入：points = [[1,5],[2,3],[4,2]]
输出：11
解释：
蓝色格子是最优方案选中的格子，坐标分别为 (0, 1)，(1, 1) 和 (2, 0) 。
你的总得分增加 5 + 3 + 4 = 12 。
但是你的总得分需要扣除 abs(1 - 1) + abs(1 - 0) = 1 。
你的最终得分为 12 - 1 = 11 。

提示：

- m == points.length
- n == points[r].length
- 1 <= m, n <= 10^5
- 1 <= m * n <= 10^5
- 0 <= points[r][c] <= 10^5
*/
func main() {
	fmt.Println("maxPoints([][]int{{1, 2, 3}, {1, 5, 1}, {3, 1, 1}}) = ",
		maxPoints([][]int{{1, 2, 3}, {1, 5, 1}, {3, 1, 1}}))
	fmt.Println("maxPoints([][]int{{1, 5}, {2, 3}, {4, 2}}) = ",
		maxPoints([][]int{{1, 5}, {2, 3}, {4, 2}}))
}

func maxPoints(points [][]int) int64 {
	m, n := len(points), len(points[0])
	best := [][]int64{make([]int64, n), make([]int64, n)}
	dp := make([][]int64, 2)
	dp[0] = make([]int64, n)
	for j := 0; j < n; j++ {
		dp[0][j] = int64(points[0][j])
	}
	for i := 1; i < m; i++ {
		best[0][0] = dp[0][0]
		for j := 1; j < n; j++ {
			best[0][j] = dp[0][j] + int64(j)
			if best[0][j] < best[0][j-1] {
				best[0][j] = best[0][j-1]
			}
		}
		best[1][n-1] = dp[0][n-1] - int64(n-1)
		for j := n - 2; j >= 0; j-- {
			best[1][j] = dp[0][j] - int64(j)
			if best[1][j] < best[1][j+1] {
				best[1][j] = best[1][j+1]
			}
		}
		dp[1] = make([]int64, n)
		for j := 0; j < n; j++ {
			dp[1][j] = int64(points[i][j]) + max(best[1][j]+int64(j), best[0][j]-int64(j))
		}
		dp[0] = dp[1]
	}
	res := dp[0][0]
	for j := 1; j < n; j++ {
		res = max(res, dp[0][j])
	}

	return res
}

func max(a, b int64) int64 {
	if a > b {
		return a
	}
	return b
}

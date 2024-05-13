package main

import "fmt"

/*
给你一个大小为 m x n 的二元矩阵 grid ，矩阵中每个元素的值为 0 或 1 。

一次 移动 是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。

在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的 得分 就是这些数字的总和。

在执行任意次 移动 后（含 0 次），返回可能的最高分数。



示例 1：


输入：grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
示例 2：

输入：grid = [[0]]
输出：1


提示：

- m == grid.length
- n == grid[i].length
- 1 <= m, n <= 20
- grid[i][j] 为 0 或 1
*/

func main() {
	fmt.Println("matrixScore([][]int{{0,0,1,1}, {1,0,1,0}, {1,1,0,0}}) = ", matrixScore([][]int{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}))
}

func matrixScore(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	for i := 0; i < m; i++ {
		if grid[i][0] == 0 {
			for j := 0; j < n; j++ {
				if grid[i][j] == 0 {
					grid[i][j] = 1
				} else {
					grid[i][j] = 0
				}
			}
		}
	}
	result := 0
	for j := 0; j < n; j++ {
		x := 0
		for i := 0; i < m; i++ {
			x += grid[i][j]
		}
		if m-x > x {
			x = m - x
		}
		result += x * (1 << (n - 1 - j))
	}
	return result
}

package main

import "fmt"

/*
3 x 3 的幻方是一个填充有 从 1 到 9  的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。

给定一个由整数组成的row x col 的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。

注意：虽然幻方只能包含 1 到 9 的数字，但 grid 可以包含最多15的数字。

示例 1：

输入: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]
输出: 1
解释:
下面的子矩阵是一个 3 x 3 的幻方：

而这一个不是：

总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
示例 2:

输入: grid = [[8]]
输出: 0

提示:

- row == grid.length
- col == grid[i].length
- 1 <= row, col <= 10
- 0 <= grid[i][j] <= 15
*/
func main() {
	fmt.Println("numMagicSquaresInside([][]int{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}) = ",
		numMagicSquaresInside([][]int{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}))
}

func numMagicSquaresInside(grid [][]int) int {
	r, c := len(grid)-2, len(grid[0])-2
	result := 0
	for i := 0; i < r; i++ {
		for j := 0; j < c; j++ {
			if isMagicSquare(i, j, grid) {
				result++
			}
		}
	}
	return result
}

func isMagicSquare(m, n int, grid [][]int) bool {
	sum := grid[m][n] + grid[m+1][n+1] + grid[m+2][n+2]
	if sum != grid[m+2][n]+grid[m+1][n+1]+grid[m][n+2] {
		return false
	}
	mp := make([]int, 10)
	for i := 0; i < 3; i++ {
		if sum != grid[m+i][n]+grid[m+i][n+1]+grid[m+i][n+2] {
			return false
		}
		for j := 0; j < 3; j++ {
			if grid[i+m][j+n] > 0 && grid[i+m][j+n] < 10 && mp[grid[i+m][j+n]] == 0 {
				mp[grid[i+m][j+n]] = 1
			} else {
				return false
			}
			if sum != grid[m][n+j]+grid[m+1][n+j]+grid[m+2][n+j] {
				return false
			}
		}
	}
	return true
}

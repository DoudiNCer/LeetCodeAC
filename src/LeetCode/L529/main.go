package main

import "fmt"

/*
*
让我们一起来玩扫雷游戏！

给你一个大小为 m x n 二维字符矩阵 board ，表示扫雷游戏的盘面，其中：

'M' 代表一个 未挖出的 地雷，
'E' 代表一个 未挖出的 空方块，
'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的 已挖出的 空白方块，
数字（'1' 到 '8'）表示有多少地雷与这块 已挖出的 方块相邻，
'X' 则表示一个 已挖出的 地雷。
给你一个整数数组 click ，其中 click = [clickr, clickc] 表示在所有 未挖出的 方块（'M' 或者 'E'）中的下一个点击位置（clickr 是行下标，clickc 是列下标）。

根据以下规则，返回相应位置被点击后对应的盘面：

如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X' 。
如果一个 没有相邻地雷 的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的 未挖出 方块都应该被递归地揭露。
如果一个 至少与一个地雷相邻 的空方块（'E'）被挖出，修改它为数字（'1' 到 '8' ），表示相邻地雷的数量。
如果在此次点击中，若无更多方块可被揭露，则返回盘面。

示例 1：

输入：board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]], click = [3,0]
输出：[["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
示例 2：

输入：board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
输出：[["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]

提示：

- m == board.length
- n == board[i].length
- 1 <= m, n <= 50
- board[i][j] 为 'M'、'E'、'B' 或数字 '1' 到 '8' 中的一个
- click.length == 2
- 0 <= clickr < m
- 0 <= clickc < n
- board[clickr][clickc] 为 'M' 或 'E'
*/
func main() {
	fmt.Println("updateBoard([][]byte{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, []int{3, 0}) = ",
		updateBoard([][]byte{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, []int{3, 0}))
	fmt.Println("updateBoard([][]byte{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, []int{1, 2}) = ",
		updateBoard([][]byte{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, []int{1, 2}))
}

func updateBoard(board [][]byte, click []int) [][]byte {
	if board[click[0]][click[1]] == 'M' {
		board[click[0]][click[1]] = 'X'
		return board
	}
	m, n := len(board), len(board[0])
	var dfs func(x, y, px, py int)
	dfs = func(x, y, px, py int) {
		cnt := 0
		for _, i := range []int{-1, 0, 1} {
			if x+i < 0 || x+i >= m {
				continue
			}
			for _, j := range []int{-1, 0, 1} {
				if y+j < 0 || y+j >= n {
					continue
				}
				if x+i == px && y+j == py {
					continue
				}
				if board[x+i][y+j] == 'M' {
					cnt++
				}
			}
		}
		if cnt > 0 {
			board[x][y] = byte('0' + cnt)
			return
		} else {
			board[x][y] = 'B'
		}
		for _, i := range []int{-1, 0, 1} {
			if x+i < 0 || x+i >= m {
				continue
			}
			for _, j := range []int{-1, 0, 1} {
				if y+j < 0 || y+j >= n {
					continue
				}
				if x+i == px && y+j == py || i == 0 && j == 0 {
					continue
				}
				if board[x+i][y+j] == 'E' {
					dfs(x+i, y+j, x, y)
				}
			}
		}
	}
	dfs(click[0], click[1], click[0], click[1])
	return board
}

package main

import "fmt"

/*
*
有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。

示例 1：

输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
输出：2
示例 2：

输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
输出：3

提示：

- 1 <= n <= 200
- n == isConnected.length
- n == isConnected[i].length
- isConnected[i][j] 为 1 或 0
- isConnected[i][i] == 1
- isConnected[i][j] == isConnected[j][i]
*/
func main() {
	fmt.Println("findCircleNum([][]int{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}) = ",
		findCircleNum([][]int{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}))
	fmt.Println("findCircleNum([][]int{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}) = ",
		findCircleNum([][]int{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}))
	fmt.Println("findCircleNum([][]int{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}) = ",
		findCircleNum([][]int{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}))
}

func findCircleNum(isConnected [][]int) int {
	n := len(isConnected)
	ucs := Init(n)
	for i := 0; i < n; i++ {
		for j := i + 1; j < n; j++ {
			if isConnected[i][j] == 1 {
				ucs.Union(i, j)
			}
		}
	}
	ps := make(map[int]struct{})
	for i := 0; i < n; i++ {
		ps[ucs.Find(i)] = struct{}{}
	}
	return len(ps)
}

type UCS []int

func Init(n int) UCS {
	u := make(UCS, n)
	for i := 0; i < n; i++ {
		u[i] = i
	}
	return u
}
func (u *UCS) Find(x int) int {
	for (*u)[x] != x {
		x = (*u)[x]
	}
	if x != (*u)[x] {
		u.Compress(x)
	}
	return x
}
func (u *UCS) IsUnion(x int, y int) bool {
	return u.Find(x) == u.Find(y)
}

func (u *UCS) Union(x, y int) {
	xp, yp := u.Find(x), u.Find(y)
	if xp == yp {
		return
	} else if xp > yp {
		(*u)[xp] = yp
		u.Compress(x)
	} else {
		(*u)[yp] = xp
		u.Compress(y)
	}
}

func (u *UCS) Compress(x int) {
	xp := u.Find(x)
	if x == xp {
		return
	}
	for (*u)[x] != xp {
		xx := x
		x = (*u)[x]
		(*u)[xx] = xp
	}
}

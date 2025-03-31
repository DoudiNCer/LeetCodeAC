package main

import "fmt"

/*
*
给你一个整数 n 。现有一个包含 n 个顶点的 无向 图，顶点按从 0 到 n - 1 编号。给你一个二维整数数组 edges 其中 edges[i] = [ai, bi] 表示顶点 ai 和 bi 之间存在一条 无向 边。

返回图中 完全连通分量 的数量。

如果在子图中任意两个顶点之间都存在路径，并且子图中没有任何一个顶点与子图外部的顶点共享边，则称其为 连通分量 。

如果连通分量中每对节点之间都存在一条边，则称其为 完全连通分量 。

示例 1：

输入：n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
输出：3
解释：如上图所示，可以看到此图所有分量都是完全连通分量。
示例 2：

输入：n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
输出：1
解释：包含节点 0、1 和 2 的分量是完全连通分量，因为每对节点之间都存在一条边。
包含节点 3 、4 和 5 的分量不是完全连通分量，因为节点 4 和 5 之间不存在边。
因此，在图中完全连接分量的数量是 1 。

提示：

- 1 <= n <= 50
- 0 <= edges.length <= n * (n - 1) / 2
- edges[i].length == 2
- 0 <= ai, bi <= n - 1
- ai != bi
- 不存在重复的边
*/
func main() {
	fmt.Println("countCompleteComponents(6, [][]int{{0, 1}, {0, 2}, {1, 2}, {3, 4}}) = ",
		countCompleteComponents(6, [][]int{{0, 1}, {0, 2}, {1, 2}, {3, 4}}))
	fmt.Println("countCompleteComponents(6, [][]int{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}}) = ",
		countCompleteComponents(6, [][]int{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}}))
}

func countCompleteComponents(n int, edges [][]int) int {
	ufs := InitUFS(n)
	for i := range edges {
		ufs.Union(edges[i][0], edges[i][1])
	}
	return ufs.SetCount()
}

type UFS struct {
	p  []int
	c  []int
	sc []int
}

func InitUFS(n int) UFS {
	ufs := UFS{
		p:  make([]int, n),
		c:  make([]int, n),
		sc: make([]int, n),
	}
	for i := 0; i < n; i++ {
		ufs.p[i] = i
		ufs.c[i] = 1
		ufs.sc[i] = 0
	}
	return ufs
}

func (ufs *UFS) Find(e int) int {
	if ufs.p[e] == e {
		return e
	}
	if ufs.p[e] == ufs.p[ufs.p[e]] {
		return ufs.p[ufs.p[e]]
	}
	ufs.p[e] = ufs.Find(ufs.p[ufs.p[e]])
	return ufs.p[e]
}

func (ufs *UFS) Union(a, b int) {
	ap, bp := ufs.Find(a), ufs.Find(b)
	if ap != bp {
		ufs.p[bp] = ap
		ufs.c[ap] += ufs.c[bp]
		ufs.sc[ap] += ufs.sc[bp]
	}
	ufs.sc[ap]++
}

func (ufs *UFS) SetCount() int {
	checked := make(map[int]struct{})
	res := 0
	for _, v := range ufs.p {
		p := ufs.Find(v)
		if _, ok := checked[p]; !ok {
			checked[p] = struct{}{}
			if ufs.sc[p] >= ufs.c[p]*(ufs.c[p]-1)/2 {
				res++
			}
		}
	}
	return res
}

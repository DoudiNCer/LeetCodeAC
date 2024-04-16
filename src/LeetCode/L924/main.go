package main

import "fmt"

/*
给出了一个由 n 个节点组成的网络，用 n × n 个邻接矩阵图 graph 表示。在节点网络中，当 graph[i][j] = 1 时，表示节点 i 能够直接连接到另一个节点 j。

一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。

假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。

如果从 initial 中移除某一节点能够最小化 M(initial)， 返回该节点。如果有多个节点满足条件，就返回索引最小的节点。

请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后仍有可能因恶意软件传播而受到感染。

示例 1：

输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
输出：0
示例 2：

输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
输出：0
示例 3：

输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
输出：1

提示：

- n == graph.length
- n == graph[i].length
- 2 <= n <= 300
- graph[i][j] == 0 或 1.
- graph[i][j] == graph[j][i]
- graph[i][i] == 1
- 1 <= initial.length <= n
- 0 <= initial[i] <= n - 1
- initial 中所有整数均不重复
*/
func main() {
	fmt.Println("minMalwareSpread([][]int{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, []int{0, 1}) = ", minMalwareSpread([][]int{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, []int{0, 1}))
	fmt.Println("minMalwareSpread([][]int{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, []int{0, 1, 2}) = ", minMalwareSpread([][]int{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, []int{0, 1, 2}))
}

func minMalwareSpread(graph [][]int, initial []int) int {
	if len(initial) == 1 {
		return initial[0]
	}
	n := len(graph)
	us := NewUnionSet(n)
	for i := 0; i < n-1; i++ {
		for j := i + 1; j < n; j++ {
			if graph[i][j] == 1 {
				us.Union(i, j)
			}
		}
	}
	minp := n
	minc := n
	for i, k := range initial {
		usb := unionSet{rank: []int{}, set: []int{}}
		for _, r := range us.rank {
			usb.rank = append(usb.rank, r)
		}
		for _, s := range us.set {
			usb.set = append(usb.set, s)
		}
		start := -1
		for j, kk := range initial {
			if j == i {
				continue
			}
			if start == -1 {
				start = kk
			} else {
				usb.Union(start, kk)
			}
		}
		cnt := usb.GetSize(start)
		if cnt < minc || (cnt == minc && k < minp) {
			minc = cnt
			minp = k
		}
	}
	return minp
}

type unionSet struct {
	rank []int
	set  []int
}

func NewUnionSet(size int) *unionSet {
	buf1 := make([]int, size)
	for i := 0; i < size; i++ {
		buf1[i] = i
	}
	buf2 := make([]int, size)
	for i := 0; i < size; i++ {
		buf2[i] = 1
	}
	return &unionSet{
		rank: buf2,
		set:  buf1,
	}
}

func (set *unionSet) GetSize(p int) int {
	p = set.getRoot(p)
	cnt := 0
	for _, q := range set.set {
		if p == q {
			cnt++
		}
	}
	return cnt
}

func (set *unionSet) getRoot(p int) int {
	for p != set.set[p] {
		p = set.set[p]
	}
	return p
}

func (set *unionSet) IsConnected(p, q int) bool {
	return set.getRoot(set.set[p]) == set.getRoot(set.set[q])
}

func (set *unionSet) Union(p, q int) {
	pRoot := set.getRoot(p)
	qRoot := set.getRoot(q)

	sr := pRoot
	lr := qRoot
	if pRoot != qRoot {
		if set.rank[pRoot] < set.rank[qRoot] {
			set.set[pRoot] = qRoot
		} else if set.rank[qRoot] < set.rank[pRoot] {
			set.set[qRoot] = pRoot
			sr = qRoot
			lr = pRoot
		} else {
			set.set[pRoot] = qRoot
			set.rank[qRoot] += 1
		}
	}
	for i, s := range set.set {
		if s == sr {
			set.set[i] = lr
		}
	}
}

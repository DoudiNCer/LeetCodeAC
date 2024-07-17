package main

/*
给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。

请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：

'L' 表示从一个节点前往它的 左孩子 节点。
'R' 表示从一个节点前往它的 右孩子 节点。
'U' 表示从一个节点前往它的 父 节点。
请你返回从 s 到 t 最短路径 每一步的方向。

示例 1：

输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
输出："UURL"
解释：最短路径为：3 → 1 → 5 → 2 → 6 。
示例 2：

输入：root = [2,1], startValue = 2, destValue = 1
输出："L"
解释：最短路径为：2 → 1 。

提示：

- 树中节点数目为 n 。
- 2 <= n <= 10^5
- 1 <= Node.val <= n
- 树中所有节点的值 互不相同 。
- 1 <= startValue, destValue <= n
startValue != destValue
*/
func main() {

}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func getDirections(root *TreeNode, startValue, destValue int) string {
	q := []*TreeNode{nil}
	parents := map[*TreeNode]*TreeNode{}
	var dfs func(node, pa *TreeNode)
	dfs = func(node, pa *TreeNode) {
		if node == nil {
			return
		}
		parents[node] = pa
		if node.Val == startValue {
			q[0] = node
		}
		dfs(node.Left, node)
		dfs(node.Right, node)
	}
	dfs(root, nil)

	ans := []byte{}
	vis := map[*TreeNode]bool{nil: true, q[0]: true}
	type pair struct {
		from *TreeNode
		dir  byte
	}
	from := map[*TreeNode]pair{}
	for len(q) > 0 {
		node := q[0]
		q = q[1:]
		if node.Val == destValue {
			for ; from[node].from != nil; node = from[node].from {
				ans = append(ans, from[node].dir)
			}
			break
		}
		if !vis[node.Left] {
			vis[node.Left] = true
			from[node.Left] = pair{node, 'L'}
			q = append(q, node.Left)
		}
		if !vis[node.Right] {
			vis[node.Right] = true
			from[node.Right] = pair{node, 'R'}
			q = append(q, node.Right)
		}
		if !vis[parents[node]] {
			vis[parents[node]] = true
			from[parents[node]] = pair{node, 'U'}
			q = append(q, parents[node])
		}
	}
	for i, n := 0, len(ans); i < n/2; i++ {
		ans[i], ans[n-1-i] = ans[n-1-i], ans[i]
	}
	return string(ans)
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

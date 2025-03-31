package main

import "fmt"

/*
*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]

提示：

- 1 <= s.length <= 16
- s 仅由小写英文字母组成
*/
func main() {
	fmt.Println("partition(\"aab\") = ", partition("aab"))
	fmt.Println("partition(\"a\") = ", partition("a"))
	fmt.Println("partition(\"abbab\") = ", partition("abbab"))
}

func partition(s string) [][]string {
	n := len(s)
	pd := make([][]bool, n)
	for j := 0; j < n; j++ {
		pd[j] = make([]bool, j+1)
		pd[j][j] = true
	}
	for i := n - 1; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			if s[i] == s[j] {
				if j-1 >= i+1 {
					pd[j][i] = pd[j-1][i+1]
				} else {
					pd[j][i] = true
				}
			}
		}
	}
	res := make([][]string, 0)
	splits := []string{}
	var dfs func(int)
	dfs = func(i int) {
		if i == n {
			res = append(res, append([]string(nil), splits...))
			return
		}
		for j := i; j < n; j++ {
			if pd[j][i] {
				splits = append(splits, s[i:j+1])
				dfs(j + 1)
				splits = splits[:len(splits)-1]
			}
		}
	}
	dfs(0)
	return res
}

package main

import "fmt"

/*
*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。

返回符合要求的 最少分割次数 。

示例 1：

输入：s = "aab"
输出：1
解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
示例 2：

输入：s = "a"
输出：0
示例 3：

输入：s = "ab"
输出：1

提示：

- 1 <= s.length <= 2000
- s 仅由小写英文字母组成
*/
func main() {
	fmt.Println("minCut(\"aab\") = ", minCut("aab"))
	fmt.Println("minCut(\"a\") = ", minCut("a"))
	fmt.Println("minCut(\"ababababababababababababcbabababababababababababa\") = ",
		minCut("ababababababababababababcbabababababababababababa"))
}

func minCut(s string) int {
	n := len(s)
	pd := make([][]bool, n)
	for j := range pd {
		pd[j] = make([]bool, j+1)
		pd[j][j] = true
	}
	for i := n - 2; i >= 0; i-- {
		for j := i + 1; j < n; j++ {
			if s[i] == s[j] {
				if j-1 < i+1 {
					pd[j][i] = true
				} else {
					pd[j][i] = pd[j-1][i+1]
				}
			}
		}
	}
	dp := make([]int, n)
	for j := range dp {
		if pd[j][0] {
			continue
		}
		dp[j] = j + 1
		for i := 0; i < j; i++ {
			if pd[j][i+1] && dp[j]+1 < dp[i] {
				dp[i] = dp[j] + 1
			}
		}
	}
	return dp[n-1]
}

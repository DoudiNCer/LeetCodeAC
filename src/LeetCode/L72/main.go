package main

import "fmt"

/*
*
给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符

示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

提示：

- 0 <= word1.length, word2.length <= 500
- word1 和 word2 由小写英文字母组成
*/
func main() {
	fmt.Println("minDistance(\"horse\", \"ros\") = ", minDistance("horse", "ros"))
}

func minDistance(word1 string, word2 string) int {
	m, n := len(word1), len(word2)
	if m*n == 0 {
		return m + n
	}
	dp := make([][]int, 2)
	dp[0] = make([]int, n+1)
	for j := 1; j <= n; j++ {
		dp[0][j] = j
	}
	for i := 1; i <= m; i++ {
		dp[1] = make([]int, n+1)
		dp[1][0] = i
		for j := 1; j <= n; j++ {
			dp[1][j] = minInt(dp[0][j], dp[1][j-1]) + 1
			if word1[i-1] == word2[j-1] {
				dp[1][j] = minInt(dp[0][j-1], dp[1][j])
			} else {
				dp[1][j] = minInt(dp[0][j-1]+1, dp[1][j])
			}
		}
		dp[0] = dp[1]
	}
	return dp[0][n]
}

func minInt(x int, y int) int {
	if x < y {
		return x
	}
	return y
}

package main

import "fmt"

/*
*
给你两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为 子序列 的最短字符串。如果答案不止一个，则可以返回满足条件的 任意一个 答案。

如果从字符串 t 中删除一些字符（也可能不删除），可以得到字符串 s ，那么 s 就是 t 的一个子序列。

示例 1：

输入：str1 = "abac", str2 = "cab"
输出："cabac"
解释：
str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
最终我们给出的答案是满足上述属性的最短字符串。
示例 2：

输入：str1 = "aaaaaaaa", str2 = "aaaaaaaa"
输出："aaaaaaaa"

提示：

- 1 <= str1.length, str2.length <= 1000
- str1 和 str2 都由小写英文字母组成。
*/
func main() {
	fmt.Println("shortestCommonSupersequence(\"babbbbaa\", \"baabbbbba\") = ",
		shortestCommonSupersequence("babbbbaa", "baabbbbba"))
	//fmt.Println("shortestCommonSupersequence(\"bbbaaaba\", \"bbababbb\") = ",
	//	shortestCommonSupersequence("bbbaaaba", "bbababbb"))
	//fmt.Println("shortestCommonSupersequence(\"aabbbbbba\", \"aaaabbaa\") = ",
	//	shortestCommonSupersequence("aabbbbbba", "aaaabbaa"))
}

func shortestCommonSupersequence(str1 string, str2 string) string {
	m, n := len(str1), len(str2)
	dp := make([][]int, m)
	dp[m-1] = make([]int, n)
	if str2[n-1] == str1[m-1] {
		dp[m-1][n-1]++
	}
	dp00 := dp[m-1][n-1]
	for j := n - 2; j >= 0; j-- {
		if dp00 == 0 && str2[j] == str1[m-1] {
			dp00++
		}
		dp[m-1][j] = dp00
	}
	dp00 = dp[m-1][n-1]
	for i := m - 2; i >= 0; i-- {
		dp[i] = make([]int, n)
		if dp00 == 0 && str1[i] == str2[n-1] {
			dp00++
		}
		dp[i][n-1] = dp00
	}
	for i := m - 2; i >= 0; i-- {
		for j := n - 2; j >= 0; j-- {
			if str1[i] == str2[j] {
				dp[i][j] = dp[i+1][j+1] + 1
			} else {
				dp[i][j] = max(dp[i+1][j], dp[i][j+1])
			}
		}
	}
	for x := range dp {
		fmt.Println(x, ": ", dp[x])
	}
	i, j := 0, 0
	li, lj := 0, 0
	dp00 = dp[0][0]
	res := make([]byte, 0, m+n-dp00)
	for {
		fmt.Println("i, j = ", i, ", ", j)
		fmt.Println("dp00 = ", dp00)
		fmt.Println("str1[i], str2[j] = ", str1[i], ", ", str2[j])
		if str1[i] == str2[j] {
			res = append(res, str1[li:i]...)
			res = append(res, str2[lj:j+1]...)
			i, j = i+1, j+1
			li, lj = i, j
			dp00--
			if dp00 == 0 {
				res = append(res, str1[li:]...)
				res = append(res, str2[lj:]...)
				break
			}
		} else {
			if i+1 < m && dp[i][j] == dp[i+1][j] {
				i, j = i+1, j
			} else if dp[i][j] == dp[i][j+1] {
				i, j = i, j+1
			}
		}
	}
	return string(res)
}

func max(a, b int) int {
	if a > b {
		return a

	}
	return b

}

package main

import "fmt"

/*
*
给你一个仅由小写英文字母组成的字符串 s 。在一步操作中，你可以：

删除 整个字符串 s ，或者
对于满足 1 <= i <= s.length / 2 的任意 i ，如果 s 中的 前 i 个字母和接下来的 i 个字母 相等 ，删除 前 i 个字母。
例如，如果 s = "ababc" ，那么在一步操作中，你可以删除 s 的前两个字母得到 "abc" ，因为 s 的前两个字母和接下来的两个字母都等于 "ab" 。

返回删除 s 所需的最大操作数。

示例 1：

输入：s = "abcabcdabc"
输出：2
解释：
- 删除前 3 个字母（"abc"），因为它们和接下来 3 个字母相等。现在，s = "abcdabc"。
- 删除全部字母。
一共用了 2 步操作，所以返回 2 。可以证明 2 是所需的最大操作数。
注意，在第二步操作中无法再次删除 "abc" ，因为 "abc" 的下一次出现并不是位于接下来的 3 个字母。
示例 2：

输入：s = "aaabaab"
输出：4
解释：
- 删除第一个字母（"a"），因为它和接下来的字母相等。现在，s = "aabaab"。
- 删除前 3 个字母（"aab"），因为它们和接下来 3 个字母相等。现在，s = "aab"。
- 删除第一个字母（"a"），因为它和接下来的字母相等。现在，s = "ab"。
- 删除全部字母。
一共用了 4 步操作，所以返回 4 。可以证明 4 是所需的最大操作数。
示例 3：

输入：s = "aaaaa"
输出：5
解释：在每一步操作中，都可以仅删除 s 的第一个字母。

提示：

- 1 <= s.length <= 4000
- s 仅由小写英文字母组成
*/
func main() {
	fmt.Println("deleteString(\"abcabcdabc\") = ", deleteString("abcabcdabc"))
	fmt.Println("deleteString(\"aaabaab\") = ", deleteString("aaabaab"))
	fmt.Println("deleteString(\"aaaaa\") = ", deleteString("aaaaa"))
}

func deleteString(s string) int {
	le := len(s)
	if func() bool {
		for i := 1; i < le; i++ {
			if s[i] != s[i-1] {
				return false
			}
		}
		return true
	}() {
		return le
	}
	lcp := make([][]int, le+1)
	lcp[le] = make([]int, le+1)
	for i := le - 1; i >= 0; i-- {
		lcp[i] = make([]int, le)
		if s[i] == s[le-1] {
			lcp[i][le-1] = 1
		}
		for j := le - 2; j > i; j-- {
			if s[i] == s[j] {
				lcp[i][j] = lcp[i+1][j+1] + 1
			}
		}
	}
	dp := make([]int, le)
	for i := le - 1; i >= 0; i-- {
		for d := 1; i+(d<<1) <= le; d++ {
			if lcp[i][i+d] >= d && dp[i] <= dp[i+d] {
				dp[i] = dp[i+d]
			}
		}
		dp[i]++
	}
	return dp[0]
}

package main

import (
	"fmt"
)

/*
*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。

	注意，你可以重复使用字典中的单词。

示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

提示：

- 1 <= s.length <= 300
- 1 <= wordDict.length <= 1000
- 1 <= wordDict[i].length <= 20
- s 和 wordDict[i] 仅由小写英文字母组成
wordDict 中的所有字符串 互不相同
*/
func main() {
	fmt.Println("wordBreak(\"leetcode\", []string{\"leet\", \"code\"}) = ",
		wordBreak("leetcode", []string{"leet", "code"}))
	fmt.Println("wordBreak(\"abcd\", []string{\"a\", \"abc\", \"b\", \"cd\"}) = ",
		wordBreak("abcd", []string{"a", "abc", "b", "cd"}))
	fmt.Println("wordBreak(\"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab\", []string{\"a\",\"aa\",\"aaa\",\"aaaa\",\"aaaaa\",\"aaaaaa\",\"aaaaaaa\",\"aaaaaaaa\",\"aaaaaaaaa\",\"aaaaaaaaaa\"}) = ",
		wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", []string{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"}))
}

func wordBreak(s string, wordDict []string) bool {
	dict := make(map[string]bool, len(wordDict))
	le, ml := len(s), 0
	for _, word := range wordDict {
		dict[word] = true
		if ml < len(word) {
			ml = len(word)
		}
	}
	dp := make([]bool, le+1)
	dp[0] = true
	for i := 1; i <= len(s); i++ {
		for j := 0; j < i; j++ {
			if dp[j] && dict[s[j:i]] {
				dp[i] = true
				break
			}
		}
	}
	return dp[le]
}

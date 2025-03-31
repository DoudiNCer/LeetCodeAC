package main

import "fmt"

/*
*
给你一个字符串 s ，它只包含三种字符 a, b 和 c 。

请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。

示例 1：

输入：s = "abcabc"
输出：10
解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
示例 2：

输入：s = "aaacb"
输出：3
解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
示例 3：

输入：s = "abc"
输出：1

提示：

- 3 <= s.length <= 5 x 10^4
- s 只包含字符 a，b 和 c 。
*/
func main() {
	fmt.Println("numberOfSubstrings(\"abcabc\") = ", numberOfSubstrings("abcabc"))
	fmt.Println("numberOfSubstrings(\"aaacb\") = ", numberOfSubstrings("aaacb"))
	fmt.Println("numberOfSubstrings(\"abc\") = ", numberOfSubstrings("abc"))
}

func numberOfSubstrings(s string) int {
	res := 0
	cnt := make([]int, 3)
	n := len(s)
	for l, r := 0, 0; l < n; l++ {
		for r < n && !(cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
			cnt[s[r]-'a']++
			r++
		}
		if cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0 {
			res += n - r + 1
		}
		cnt[s[l]-'a']--
	}
	return res
}

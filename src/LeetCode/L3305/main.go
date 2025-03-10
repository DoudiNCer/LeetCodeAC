package main

import "fmt"

/*
*
给你一个字符串 word 和一个 非负 整数 k。

返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数。

示例 1：

输入：word = "aeioqq", k = 1

输出：0

解释：

不存在包含所有元音字母的子字符串。

示例 2：

输入：word = "aeiou", k = 0

输出：1

解释：

唯一一个包含所有元音字母且不含辅音字母的子字符串是 word[0..4]，即 "aeiou"。

示例 3：

输入：word = "ieaouqqieaouqq", k = 1

输出：3

解释：

包含所有元音字母并且恰好含有一个辅音字母的子字符串有：

word[0..5]，即 "ieaouq"。
word[6..11]，即 "qieaou"。
word[7..12]，即 "ieaouq"。

提示：

- 5 <= word.length <= 250
- word 仅由小写英文字母组成。
- 0 <= k <= word.length - 5
*/
func main() {
	fmt.Println("countOfSubstrings(\"aeioqq\", 1) = ", countOfSubstrings("aeioqq", 1))
	fmt.Println("countOfSubstrings(\"aeiou\", 0) = ", countOfSubstrings("aeiou", 0))
	fmt.Println("countOfSubstrings(\"ieaouqqieaouqq\", 1) = ", countOfSubstrings("ieaouqqieaouqq", 1))
}

func countOfSubstrings(word string, k int) int {
	res := 0
	n := len(word)
	for l := 0; l < n-k-4; l++ {
		cnt := make([]int, 6)
		for i := l; i < n; i++ {
			cnt[hs(word[i])]++
			if cnt[0] == k && cnt[1] > 0 && cnt[2] > 0 && cnt[3] > 0 && cnt[4] > 0 && cnt[5] > 0 {
				res++
			}
		}
	}
	return res
}

func hs(c byte) int {
	switch c {
	case 'a':
		return 1
	case 'e':
		return 2
	case 'i':
		return 3
	case 'o':
		return 4
	case 'u':
		return 5
	default:
		return 0
	}
}

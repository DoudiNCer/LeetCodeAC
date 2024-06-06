package main

import "fmt"

/*
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

	示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

提示:

- 1 <= s.length, p.length <= 3 * 10^4
- s 和 p 仅包含小写字母
*/
func main() {
	fmt.Println("findAnagrams(\"cbaebabacd\", \"abc\") = ", findAnagrams("cbaebabacd", "abc"))
}

func findAnagrams(s string, p string) []int {
	ls, lp := len(s), len(p)
	var result []int
	if ls < lp {
		return result
	}
	chp := make([]int, 26)
	chs := make([]int, 26)
	for i, c := range p {
		chp[c-'a']++
		chs[s[i]-'a']++
	}
	for i := 0; i <= ls-lp; i++ {
		if func() bool {
			for i := 0; i < 26; i++ {
				if chs[i] != chp[i] {
					return false
				}
			}
			return true
		}() {
			result = append(result, i)
			for i+lp < ls && s[i] == s[i+lp] {
				i++
				result = append(result, i)
			}
		}
		if i+lp < ls {
			chs[s[i]-'a']--
			chs[s[i+lp]-'a']++
		}
	}
	return result
}

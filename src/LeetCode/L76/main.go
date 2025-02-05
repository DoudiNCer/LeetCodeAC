package main

import "fmt"

/*
*
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。

示例 1：

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
示例 2：

输入：s = "a", t = "a"
输出："a"
解释：整个字符串 s 是最小覆盖子串。
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。

提示：

- m == s.length
- n == t.length
- 1 <= m, n <= 10^5
- s 和 t 由英文字母组成
*/
func main() {
	fmt.Println("minWindow(\"ADOBECODEBANC\", \"ABC\") = ", minWindow("ADOBECODEBANC", "ABC"))
}

func minWindow(s string, t string) string {
	m, n := len(s), len(t)
	scnt, tcnt := make(map[uint8]int, 0), make(map[uint8]int, 0)
	for i := 0; i < n; i++ {
		tcnt[t[i]]++
	}
	check := func() bool {
		for k, v := range tcnt {
			if scnt[k] < v {
				return false
			}
		}
		return true
	}
	var (
		ansl   = -1
		ansr   = -1
		anslen = m + 1
	)
	for l, r := 0, 0; r < m; r++ {
		if r < m && tcnt[s[r]] > 0 {
			scnt[s[r]]++
		}
		for check() && l <= r {
			if r-l+1 < anslen {
				anslen = r - l + 1
				ansl, ansr = l, l+anslen
			}
			if _, ok := tcnt[s[l]]; ok {
				scnt[s[l]] -= 1
			}
			l++
		}
	}
	if anslen > m {
		return ""
	}
	return s[ansl:ansr]
}

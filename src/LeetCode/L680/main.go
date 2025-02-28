package main

import "fmt"

/*
*
给你一个字符串 s，最多 可以从中删除一个字符。

请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。

示例 1：

输入：s = "aba"
输出：true
示例 2：

输入：s = "abca"
输出：true
解释：你可以删除字符 'c' 。
示例 3：

输入：s = "abc"
输出：false

提示：

- 1 <= s.length <= 10^5
- s 由小写英文字母组成
*/
func main() {
	fmt.Println("validPalindrome(\"aba\") = ", validPalindrome("aba"))
	fmt.Println("validPalindrome(\"abca\") = ", validPalindrome("abca"))
	fmt.Println("validPalindrome(\"abc\") = ", validPalindrome("abc"))
}

func validPalindrome(s string) bool {
	le := len(s)
	if le < 3 {
		return true
	}
	var check func(int, int) bool
	cnt := 1
	check = func(l, r int) bool {
		if r-l-cnt < 1 {
			return true
		}
		if s[l] == s[r] {
			return check(l+1, r-1)
		} else {
			if cnt == 0 {
				return false
			}
			cnt--
			result := check(l+1, r) || check(l, r-1)
			cnt++
			return result
		}
	}
	return check(0, le-1)
}

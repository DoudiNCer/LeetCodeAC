package main

import "fmt"

/*
*
如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。

字母和数字都属于字母数字字符。

给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。

示例 1：

输入: s = "A man, a plan, a canal: Panama"
输出：true
解释："amanaplanacanalpanama" 是回文串。
示例 2：

输入：s = "race a car"
输出：false
解释："raceacar" 不是回文串。
示例 3：

输入：s = " "
输出：true
解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
由于空字符串正着反着读都一样，所以是回文串。

提示：

- 1 <= s.length <= 2 * 10^5
- s 仅由可打印的 ASCII 字符组成
*/
func main() {
	fmt.Println("isPalindrome(\"A man, a plan, a canal: Panama\") = ",
		isPalindrome("A man, a plan, a canal: Panama"))
	fmt.Println("isPalindrome(\"race a car\") = ", isPalindrome("race a car"))
}

func isPalindrome(s string) bool {
	le := len(s)
	if le < 2 {
		return true
	}
	str := []byte(s)
	var skip func(int) bool
	skip = func(i int) bool {
		if i >= le || i < 0 {
			return true
		}
		if str[i] >= 'A' && str[i] <= 'Z' {
			str[i] += 'a' - 'A'
		}
		return !(str[i] >= 'a' && str[i] <= 'z' || str[i] >= '0' && str[i] <= '9')
	}
	for l, r := 0, le-1; l < r; {
		if skip(l) {
			l++
			continue
		}
		if skip(r) {
			r--
			continue
		}
		if str[l] != str[r] {
			return false
		}
		l++
		r--
	}
	return true
}

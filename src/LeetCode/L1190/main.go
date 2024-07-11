package main

import (
	"fmt"
	"strings"
)

/*
给出一个字符串 s（仅含有小写英文字母和括号）。

请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

注意，您的结果中 不应 包含任何括号。

示例 1：

输入：s = "(abcd)"
输出："dcba"
示例 2：

输入：s = "(u(love)i)"
输出："iloveu"
解释：先反转子字符串 "love" ，然后反转整个字符串。
示例 3：

输入：s = "(ed(et(oc))el)"
输出："leetcode"
解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
示例 4：

输入：s = "a(bcdefghijkl(mno)p)q"
输出："apmnolkjihgfedcbq"

提示：

- 1 <= s.length <= 2000
- s 中只有小写英文字母和括号
- 题目测试用例确保所有括号都是成对出现的
*/
func main() {
	fmt.Println("reverseParentheses(\"(ed(et(oc))el)\") = ", reverseParentheses("(ed(et(oc))el)"))
}

func reverseParentheses(s string) string {
	var stack []int
	le := len(s)
	for i := 0; i < le; i++ {
		switch s[i] {
		case '(':
			stack = append(stack, i)
		case ')':
			sl := len(stack) - 1
			l := stack[sl]
			stack = stack[:sl]
			if i != le-1 {
				s = s[:l] + reverse(s, l, i) + s[i+1:]
			} else {
				s = s[:l] + reverse(s, l, i)
			}
		}
	}
	sb := strings.Builder{}
	for _, c := range s {
		switch c {
		case '(', ')':
		default:
			sb.WriteRune(c)

		}
	}
	return sb.String()
}

func reverse(s string, l, r int) string {
	sb := strings.Builder{}
	for r >= l {
		sb.WriteRune(rune(s[r]))
		r--
	}
	return sb.String()
}

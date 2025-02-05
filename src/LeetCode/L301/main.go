package main

import "fmt"

/*
*
给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。

返回所有可能的结果。答案可以按 任意顺序 返回。

示例 1：

输入：s = "()())()"
输出：["(())()","()()()"]
示例 2：

输入：s = "(a)())()"
输出：["(a())()","(a)()()"]
示例 3：

输入：s = ")("
输出：[""]

提示：

- 1 <= s.length <= 25
- s 由小写英文字母以及括号 '(' 和 ')' 组成
- s 中至多含 20 个括号
*/
func main() {
	fmt.Println("removeInvalidParentheses(\"()())()\") = ", removeInvalidParentheses("()())()"))
}

func isValid(str string) bool {
	cnt := 0
	for _, ch := range str {
		if ch == '(' {
			cnt++
		} else if ch == ')' {
			cnt--
			if cnt < 0 {
				return false
			}
		}
	}
	return cnt == 0
}

func helper(ans *[]string, str string, start, lremove, rremove int) {
	if lremove == 0 && rremove == 0 {
		if isValid(str) {
			*ans = append(*ans, str)
		}
		return
	}

	for i := start; i < len(str); i++ {
		if i != start && str[i] == str[i-1] {
			continue
		}

		if lremove+rremove > len(str)-i {
			return
		}

		if lremove > 0 && str[i] == '(' {
			helper(ans, str[:i]+str[i+1:], i, lremove-1, rremove)
		}

		if rremove > 0 && str[i] == ')' {
			helper(ans, str[:i]+str[i+1:], i, lremove, rremove-1)
		}
	}
}

func removeInvalidParentheses(s string) (ans []string) {
	lremove, rremove := 0, 0
	for _, ch := range s {
		switch ch {
		case '(':
			lremove++
		case ')':
			if lremove == 0 {
				rremove++
			} else {
				lremove--
			}
		}
	}

	helper(&ans, s, 0, lremove, rremove)
	return
}

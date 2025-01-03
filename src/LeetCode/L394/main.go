package main

import (
	"fmt"
	"strings"
)

/*
*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例 1：

输入：s = "3[a]2[bc]"
输出："aaabcbc"
示例 2：

输入：s = "3[a2[c]]"
输出："accaccacc"
示例 3：

输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"
示例 4：

输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"

提示：

- 1 <= s.length <= 30
- s 由小写英文字母、数字和方括号 '[]' 组成
- s 保证是一个 有效 的输入。
- s 中所有整数的取值范围为 [1, 300]
*/
func main() {
	fmt.Println("decodeString(\"3[a]2[bc]\") = ", decodeString("3[a]2[bc]"))
	fmt.Println("decodeString(\"3[a2[c]]\") = ", decodeString("3[a2[c]]"))
}

func decodeString(s string) string {
	var (
		result = strings.Builder{}
		cnt    = 0
		le     = len(s)
		p      = 0
		p0     = 0
		cucnt  = 0
	)
	for p < le {
		p0 = p
		for p < le && s[p] >= 'a' && s[p] <= 'z' {
			p++
		}
		if p != p0 {
			result.WriteString(s[p0:p])
			if p == le {
				break
			}
		}
		cnt = 0
		for s[p] >= '0' && s[p] <= '9' {
			cnt *= 10
			cnt += int(s[p] - '0')
			p++
		}
		p0 = p + 1
		cucnt = 1
		for cucnt != 0 {
			p++
			switch s[p] {
			case '[':
				cucnt++
			case ']':
				cucnt--
			}
		}
		subs := decodeString(s[p0:p])
		for i := 0; i < cnt; i++ {
			result.WriteString(subs)
		}
		p++
	}
	return result.String()
}

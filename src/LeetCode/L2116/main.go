package main

import "fmt"

/*
*
一个括号字符串是只由 '(' 和 ')' 组成的 非空 字符串。如果一个字符串满足下面 任意 一个条件，那么它就是有效的：

字符串为 ().
它可以表示为 AB（A 与 B 连接），其中A 和 B 都是有效括号字符串。
它可以表示为 (A) ，其中 A 是一个有效括号字符串。
给你一个括号字符串 s 和一个字符串 locked ，两者长度都为 n 。locked 是一个二进制字符串，只包含 '0' 和 '1' 。对于 locked 中 每一个 下标 i ：

如果 locked[i] 是 '1' ，你 不能 改变 s[i] 。
如果 locked[i] 是 '0' ，你 可以 将 s[i] 变为 '(' 或者 ')' 。
如果你可以将 s 变为有效括号字符串，请你返回 true ，否则返回 false 。

示例 1：

输入：s = "))()))", locked = "010100"
输出：true
解释：locked[1] == '1' 和 locked[3] == '1' ，所以我们无法改变 s[1] 或者 s[3] 。
我们可以将 s[0] 和 s[4] 变为 '(' ，不改变 s[2] 和 s[5] ，使 s 变为有效字符串。
示例 2：

输入：s = "()()", locked = "0000"
输出：true
解释：我们不需要做任何改变，因为 s 已经是有效字符串了。
示例 3：

输入：s = ")", locked = "0"
输出：false
解释：locked 允许改变 s[0] 。
但无论将 s[0] 变为 '(' 或者 ')' 都无法使 s 变为有效字符串。
示例 4：

输入：s = "(((())(((())", locked = "111111010111"
输出：true
解释：locked 允许我们改变 s[6] 和 s[8]。
我们将 s[6] 和 s[8] 改为 ')' 使 s 变为有效字符串。

提示：

- n == s.length == locked.length
- 1 <= n <= 10^5
- s[i] 要么是 '(' 要么是 ')' 。
- locked[i] 要么是 '0' 要么是 '1' 。
*/
func main() {
	fmt.Println("canBeValid(\"))()))\", \"010100\") = ", canBeValid("))()))", "010100"))
}

func canBeValid(s string, locked string) bool {
	n := len(s)
	if n&1 == 1 {
		return false
	}
	mx, mi := 0, 0
	for i := 0; i < n; i++ {
		if locked[i] == '1' {
			if s[i] == '(' {
				mx++
				mi++
			} else {
				mx--
				mi--
			}
			mi = max(mi, (i+1)&1)
		} else {
			mx++
			mi = max(mi-1, (i+1)&1)
		}
		if mx < mi {
			return false
		}
	}
	return mi == 0
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

package main

import "fmt"

/*
*
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

示例 1：

输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：

输入：s = "abcd", k = 2
输出："bacd"

提示：

- 1 <= s.length <= 10^4
- s 仅由小写英文组成
- 1 <= k <= 10^4
*/
func main() {
	fmt.Println("reverseStr(\"abcdefg\", 2) = ", reverseStr("abcdefg", 2))
	fmt.Println("reverseStr(\"abcdefg\", 8) = ", reverseStr("abcdefg", 8))
}

func reverseStr(s string, k int) string {
	if k <= 1 {
		return s
	}
	le := len(s)
	str := []byte(s)
	var reverse func(int)
	reverse = func(x int) {
		y := x + k - 1
		if y >= le {
			y = le - 1
		}
		for x < y {
			str[x], str[y] = str[y], str[x]
			x++
			y--
		}
	}
	for i := 0; i < le; i += 2 * k {
		reverse(i)
	}
	return string(str)
}

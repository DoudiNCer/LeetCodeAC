package main

import (
	"fmt"
	"strings"
)

/*
*
给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。

你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件：

num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。
如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。
如果 pattern[i] == 'D' ，那么 num[i] > num[i + 1] 。
请你返回满足上述条件字典序 最小 的字符串 num。

示例 1：

输入：pattern = "IIIDIDDD"
输出："123549876"
解释：
下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。
下标 3 ，5 ，6 和 7 处，我们需要使 num[i] > num[i+1] 。
一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
"123549876" 是满足条件最小的数字。
注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。
示例 2：

输入：pattern = "DDD"
输出："4321"
解释：
一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
"4321" 是满足条件最小的数字。

提示：

-  1 <= pattern.length <= 8
- pattern 只包含字符 'I' 和 'D' 。
*/
func main() {
	fmt.Println("smallestNumber(\"IIIDIDDD\") = ", smallestNumber("IIIDIDDD"))
}

func smallestNumber(pattern string) string {
	used := make([]bool, 10)
	res := make([]int, len(pattern)+1)
	var dfs func(int) bool
	dfs = func(i int) bool {
		if i == len(pattern) {
			return true
		}
		if pattern[i] == 'I' {
			for c := res[i] + 1; c < 10; c++ {
				if used[c] {
					continue
				}
				used[c] = true
				res[i+1] = c
				if dfs(i + 1) {
					return true
				} else {
					used[c] = false
				}
			}
		} else {
			for c := 1; c < res[i]; c++ {
				if used[c] {
					continue
				}
				used[c] = true
				res[i+1] = c
				if dfs(i + 1) {
					return true
				} else {
					used[c] = false
				}
			}
		}
		return false
	}
	res[0] = 1
	for ; res[0] < 10; res[0]++ {
		used[res[0]] = true
		if dfs(0) {
			break
		}
		used[res[0]] = false
	}
	sb := strings.Builder{}
	for i := 0; i < len(res); i++ {
		sb.WriteRune(rune('0' + res[i]))
	}
	return sb.String()
}

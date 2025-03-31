package main

import "fmt"

/*
*
给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。

只有能满足下述所有条件的字符串才能称为 平衡字符串 ：

字符串是一个空字符串，或者
字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
你可以交换 任意 两个下标所对应的括号 任意 次数。

返回使 s 变成 平衡字符串 所需要的 最小 交换次数。

示例 1：

输入：s = "][]["
输出：1
解释：交换下标 0 和下标 3 对应的括号，可以使字符串变成平衡字符串。
最终字符串变成 "[[]]" 。
示例 2：

输入：s = "]]][[["
输出：2
解释：执行下述操作可以使字符串变成平衡字符串：
- 交换下标 0 和下标 4 对应的括号，s = "[]][][" 。
- 交换下标 1 和下标 5 对应的括号，s = "[[][]]" 。
最终字符串变成 "[[][]]" 。
示例 3：

输入：s = "[]"
输出：0
解释：这个字符串已经是平衡字符串。

提示：

- n == s.length
- 2 <= n <= 10^6
- n 为偶数
- s[i] 为'[' 或 ']'
- 开括号 '[' 的数目为 n / 2 ，闭括号 ']' 的数目也是 n / 2
*/
func main() {
	fmt.Println("minSwaps(\"][][\") = ", minSwaps("][]["))
	fmt.Println("minSwaps(\"]]][[[\") = ", minSwaps("]]][[["))
	fmt.Println("minSwaps(\"[]\") = ", minSwaps("[]"))
}

func minSwaps(s string) int {
	res := 0
	for l, cnt, r := 0, 0, len(s)-1; l < r; l++ {
		if s[l] == '[' {
			cnt--
			continue
		}
		if cnt < 0 {
			cnt++
			continue
		}
		for s[r] == ']' {
			r--
		}
		res++
		r--
		cnt--
	}
	return res
}

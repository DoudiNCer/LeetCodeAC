package main

import "fmt"

/*
给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。

示例 1：

输入：num = "51230100"
输出："512301"
解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
示例 2：

输入：num = "123"
输出："123"
解释：整数 "123" 不含尾随零，返回整数 "123" 。

提示：

1 <= num.length <= 1000
num 仅由数字 0 到 9 组成
num 不含前导零
*/
func main() {
	fmt.Println("removeTrailingZeros(\"51230100\") = ", removeTrailingZeros("51230100"))
}

func removeTrailingZeros(num string) string {
	p := len(num) - 1
	for p >= 0 && num[p] == '0' {
		p--
	}
	if p < 0 {
		p = 0
	}
	return num[:p+1]
}

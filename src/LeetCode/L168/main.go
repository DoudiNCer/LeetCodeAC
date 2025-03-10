package main

import "fmt"

/*
*
给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

例如：

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...

示例 1：

输入：columnNumber = 1
输出："A"
示例 2：

输入：columnNumber = 28
输出："AB"
示例 3：

输入：columnNumber = 701
输出："ZY"
示例 4：

输入：columnNumber = 2147483647
输出："FXSHRXW"

提示：

- 1 <= columnNumber <= 2^31 - 1
*/
func main() {
	fmt.Println("convertToTitle(1) = ", convertToTitle(1))
	fmt.Println("convertToTitle(28) = ", convertToTitle(28))
	fmt.Println("convertToTitle(701) = ", convertToTitle(701))
	fmt.Println("convertToTitle(2147483647) = ",
		convertToTitle(2147483647))
}

func convertToTitle(columnNumber int) string {
	if columnNumber <= 0 {
		return ""
	}
	res := make([]byte, 0)
	for columnNumber > 0 {
		columnNumber -= 1
		res = append(res, byte('A'+columnNumber%26))
		columnNumber /= 26
	}
	for l, r := 0, len(res)-1; l < r; l, r = l+1, r-1 {
		res[l], res[r] = res[r], res[l]
	}
	return string(res)
}

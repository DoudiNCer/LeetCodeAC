package main

import (
	"fmt"
	"strconv"
)

/*
给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。

注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。

示例 1：

输入：n = 2
输出："110"
解释：(-2)^2 + (-2)^1 = 2
示例 2：

输入：n = 3
输出："111"
解释：(-2)2 + (-2)1 + (-2)0 = 3
示例 3：

输入：n = 4
输出："100"
解释：(-2)2 = 4

提示：

- 0 <= n <= 10^9
*/
func main() {
	fmt.Println("baseNeg2(1234) = ", baseNeg2(1234))
}

func baseNeg2(n int) string {
	if n == 0 || n == 1 {
		return strconv.Itoa(n)
	}
	var res []byte
	for n != 0 {
		remainder := n & 1
		res = append(res, '0'+byte(remainder))
		n -= remainder
		n /= -2
	}
	for i, n := 0, len(res); i < n/2; i++ {
		res[i], res[n-1-i] = res[n-1-i], res[i]
	}
	return string(res)
}

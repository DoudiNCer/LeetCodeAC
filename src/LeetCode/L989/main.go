package main

import "fmt"

/*
整数的 数组形式  num 是按照从左到右的顺序表示其数字的数组。

例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。
给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。



示例 1：

输入：num = [1,2,0,0], k = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234
示例 2：

输入：num = [2,7,4], k = 181
输出：[4,5,5]
解释：274 + 181 = 455
示例 3：

输入：num = [2,1,5], k = 806
输出：[1,0,2,1]
解释：215 + 806 = 1021


提示：

- 1 <= num.length <= 10^4
- 0 <= num[i] <= 9
- num 不包含任何前导零，除了零本身
- 1 <= k <= 10^4
*/

func main() {
	fmt.Println("addToArrayForm([]int{2, 1, 5}, 806) = ", addToArrayForm([]int{2, 1, 5}, 806))
}

func addToArrayForm(num []int, k int) []int {
	for i := len(num) - 1; k > 0; i-- {
		if i < 0 {
			num = append([]int{0}, num...)
			i = 0
		}
		num[i] += k % 10
		k /= 10
		if num[i] > 9 {
			k++
			num[i] %= 10
		}
	}
	return num
}

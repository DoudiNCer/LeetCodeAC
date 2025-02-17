package main

import "fmt"

/*
*
给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。

请你找到并返回这个整数

示例：

输入：arr = [1,2,2,6,6,6,6,7,10]
输出：6

提示：

- 1 <= arr.length <= 10^4
- 0 <= arr[i] <= 10^5
*/
func main() {
	fmt.Println("findSpecialInteger([]int{1, 2, 2, 6, 6, 6, 6, 7, 10}) = ",
		findSpecialInteger([]int{1, 2, 2, 6, 6, 6, 6, 7, 10}))
}

func findSpecialInteger(arr []int) int {
	le := len(arr)
	if le < 3 {
		return arr[0]
	}
	for i := 0; i < le; i++ {
		if arr[i+le>>2] == arr[i] {
			return arr[i]
		}
	}
	return arr[0]
}

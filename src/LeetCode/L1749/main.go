package main

import "fmt"

/*
*
给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。

请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。

abs(x) 定义如下：

如果 x 是负整数，那么 abs(x) = -x 。
如果 x 是非负整数，那么 abs(x) = x 。

示例 1：

输入：nums = [1,-3,2,3,-4]
输出：5
解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
示例 2：

输入：nums = [2,-5,1,-4,3,-2]
输出：8
解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。

提示：

- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
*/
func main() {
	fmt.Println("maxAbsoluteSum([]int{1, -3, 2, 3, -4}) = ",
		maxAbsoluteSum([]int{1, -3, 2, 3, -4}))
}

func maxAbsoluteSum(nums []int) int {
	maxB := nums[0]
	sum := maxB
	for i := 1; i < len(nums); i++ {
		sum = max(nums[i], nums[i]+sum)
		maxB = max(maxB, sum)
	}
	minB := nums[0]
	sum = minB
	for i := 1; i < len(nums); i++ {
		sum = min(nums[i], nums[i]+sum)
		minB = min(minB, sum)
	}
	return max(maxB, -minB)
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

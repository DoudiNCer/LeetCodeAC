package main

import "fmt"

/*
*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组
是数组中的一个连续部分。

示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [5,4,-1,7,8]
输出：23

提示：

- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
*/
func main() {
	fmt.Println("maxSubArray([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}) = ", maxSubArray([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
}

func maxSubArray(arr []int) int {
	if len(arr) == 1 {
		return arr[0]
	}

	best := arr[0]
	sum := arr[0]
	for i := 1; i < len(arr); i++ {
		sum = max(arr[i], sum+arr[i])
		best = max(best, sum)
	}
	return best
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

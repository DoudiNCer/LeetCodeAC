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

func maxSubArray(nums []int) int {
	fmt.Println("nums = ", nums)
	le, result := len(nums), nums[0]
	for i := 1; i < le; i++ {
		nums[i] += nums[i-1]
		result = max(nums[i], result)
	}
	maxs := make([]int, le)
	maxs[le-1] = nums[le-1]
	for i := le - 2; i >= 0; i-- {
		maxs[i] = max(nums[i], maxs[i+1])
	}
	for i := 0; i < le-1; i++ {
		if nums[i] < 0 {
			result = max(result, maxs[i+1]-nums[i])
		}
	}
	return result
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

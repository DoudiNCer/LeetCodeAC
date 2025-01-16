package main

import "fmt"

/*
*
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

子数组是数组中元素的连续非空序列。

示例 1：

输入：nums = [1,1,1], k = 2
输出：2
示例 2：

输入：nums = [1,2,3], k = 3
输出：2

提示：

- 1 <= nums.length <= 2 * 10^4
- -1000 <= nums[i] <= 1000
- -10^7 <= k <= 10^7
*/
func main() {
	fmt.Println("subarraySum([]int{1, 1, 1}, 2) = ", subarraySum([]int{1, 1, 1}, 2))
	fmt.Println("subarraySum([]int{1, 2, 3}, 3) = ", subarraySum([]int{1, 2, 3}, 3))
}

func subarraySum(nums []int, k int) int {
	result := 0
	if nums[0] == k {
		result++
	}
	le := len(nums)
	if le == 1 {
		return result
	}
	for i := 1; i < le; i++ {
		nums[i] += nums[i-1]
		if nums[i] == k {
			result++
		}
		for j := 0; j < i; j++ {
			if nums[i]-nums[j] == k {
				result++
			}
		}
	}
	return result
}

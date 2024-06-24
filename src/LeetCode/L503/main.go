package main

import "fmt"

/*
给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。

数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。

示例 1:

输入: nums = [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数；
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
示例 2:

输入: nums = [1,2,3,4,3]
输出: [2,3,4,-1,4]

提示:

- 1 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
*/
func main() {
	fmt.Println("nextGreaterElements([]int{1,2,1}) = ", nextGreaterElements([]int{1, 2, 1}))
}

func nextGreaterElements(nums []int) []int {
	var stack []int
	le := len(nums)
	result := make([]int, le)
	maxNum := nums[0]
	maxP := []int{}
	for i := 0; i < le; i++ {
		if maxNum < nums[i] {
			maxNum = nums[i]
			maxP = []int{i}
		} else if maxNum == nums[i] {
			maxP = append(maxP, i)
		}
		result[i] = nums[i]
	}
	for i := 0; i < le; i++ {
		if len(stack) == 0 || nums[stack[len(stack)-1]] >= nums[i] {
			stack = append(stack, i)
		} else {
			for len(stack) > 0 && nums[stack[len(stack)-1]] < nums[i] {
				result[stack[len(stack)-1]] = nums[i]
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, i)
		}
	}
	for i := 0; i < le && len(stack) > 0; i++ {
		if nums[stack[len(stack)-1]] >= nums[i] {
			stack = append(stack, i)
		} else {
			for len(stack) > 0 && nums[stack[len(stack)-1]] < nums[i] {
				result[stack[len(stack)-1]] = nums[i]
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, i)
		}
	}
	for _, i := range maxP {
		result[i] = -1
	}
	return result
}

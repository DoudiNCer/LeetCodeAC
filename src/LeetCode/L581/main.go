package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

请你找出符合题意的 最短 子数组，并输出它的长度。

示例 1：

输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
示例 2：

输入：nums = [1,2,3,4]
输出：0
示例 3：

输入：nums = [1]
输出：0

提示：

- 1 <= nums.length <= 10^4
- -10^5 <= nums[i] <= 10^5
*/
func main() {
	fmt.Println("findUnsortedSubarray([]int{2, 6, 4, 8, 10, 9, 15}) = ",
		findUnsortedSubarray([]int{2, 6, 4, 8, 10, 9, 15}))
}

func findUnsortedSubarray(nums []int) int {
	le := len(nums)
	if le == 1 {
		return 0
	}
	if nums[0] > nums[le-1] {
		return le
	}
	desc := make([]int, le)
	for i, num := range nums {
		desc[i] = num
	}
	sort.Ints(desc)
	result := le
	for i := result - 1; i >= 0 && nums[i] == desc[i]; i-- {
		result--
	}
	for i, p := 0, result; i < p && nums[i] == desc[i]; i++ {
		result--
	}
	return result
}

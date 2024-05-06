package main

import (
	"fmt"
	"sort"
)

/*
给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。

返回正整数 k ，如果不存在这样的整数，返回 -1 。

示例 1：

输入：nums = [-1,2,-3,3]
输出：3
解释：3 是数组中唯一一个满足题目要求的 k 。
示例 2：

输入：nums = [-1,10,6,7,-7,1]
输出：7
解释：数组中存在 1 和 7 对应的负数，7 的值更大。
示例 3：

输入：nums = [-10,8,6,7,-2,-3]
输出：-1
解释：不存在满足题目要求的 k ，返回 -1 。

提示：

- 1 <= nums.length <= 1000
- -1000 <= nums[i] <= 1000
nums[i] != 0
*/
func main() {
	fmt.Println("findMaxK([]int{-1,2,-3,3}) = ", findMaxK([]int{-1, 2, -3, 3}))
}

func findMaxK(nums []int) int {
	negs := map[int]struct{}{}
	sort.Ints(nums)
	le := len(nums)
	p := 0
	for p < le && nums[p] < 0 {
		negs[-nums[p]] = struct{}{}
		p++
	}
	if p == le {
		return -1
	}
	nums = nums[p:]
	le -= p
	for i := le - 1; i >= 0; i-- {
		if _, ok := negs[nums[i]]; ok {
			return nums[i]
		}
	}
	return -1
}

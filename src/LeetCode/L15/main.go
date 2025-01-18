package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。

提示：

- 3 <= nums.length <= 3000
- -10^5 <= nums[i] <= 10^5
*/
func main() {
	fmt.Println("threeSum([]int{-1, 0, 1, 2, -1, -4}) = ", threeSum([]int{-1, 0, 1, 2, -1, -4}))
	fmt.Println("threeSum([]int{0, 1, 1}) = ", threeSum([]int{0, 1, 1}))
	fmt.Println("threeSum([]int{0, 0, 0}) = ", threeSum([]int{0, 0, 0}))
}

func threeSum(nums []int) [][]int {
	keys := make(map[int]map[int]any)
	for i, num := range nums {
		set, ok := keys[num]
		if !ok {
			set = make(map[int]any)
		}
		set[i] = num
		keys[num] = set
	}
	result := make([][]int, 0)
	exists := make(map[uint64]bool)
	for i := 0; i < len(nums)-2; i++ {
		z := nums[i]
		for j := i + 1; j < len(nums)-1; j++ {
			s := nums[j]
			w := -z - s
			hs := hash([]int{z, s, w})
			if exists[hs] {
				continue
			}
			set, exist := keys[w]
			if !exist {
				continue
			}
			k := -1
			for kk, _ := range set {
				if kk <= j {
					continue
				}
				k = kk
			}
			if k == -1 {
				continue
			}
			exists[hs] = true
			result = append(result, []int{z, s, w})
		}
	}
	return result
}

func hash(nums []int) uint64 {
	sort.Ints(nums)
	hs := uint64(0)
	for _, num := range nums {
		hs <<= 1
		if num < 0 {
			hs += 1
			num = -num
		}
		hs <<= 20
		hs += uint64(num)
	}
	return hs
}

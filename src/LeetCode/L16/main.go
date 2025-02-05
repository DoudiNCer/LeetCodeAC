package main

import (
	"math"
	"sort"
)

/*
*
给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。

示例 1：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)。
示例 2：

输入：nums = [0,0,0], target = 1
输出：0
解释：与 target 最接近的和是 0（0 + 0 + 0 = 0）。

提示：

- 3 <= nums.length <= 1000
- -1000 <= nums[i] <= 1000
- -10^4 <= target <= 10^4
*/
func main() {

}

func threeSumClosest(nums []int, target int) int {
	sort.Ints(nums)
	le := len(nums)
	zsw := math.MaxInt
	for i := 0; i < le-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		j, k := i+1, le-1
		for j < k {
			if sw := nums[i] + nums[j] + nums[k]; sw == target {
				return target
			} else if sw > target {
				if abs(zsw-target) > sw-target {
					zsw = sw
				}
				for k > j && nums[k] == nums[k-1] {
					k--
				}
				k--
			} else {
				if abs(zsw-target) > target-sw {
					zsw = sw
				}
				for j < k && nums[j] == nums[j+1] {
					j++
				}
				j++
			}
		}
	}
	return zsw
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

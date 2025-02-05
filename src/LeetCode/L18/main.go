package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。

示例 1：

输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
示例 2：

输入：nums = [2,2,2,2,2], target = 8
输出：[[2,2,2,2]]

提示：

- 1 <= nums.length <= 200
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9
*/
func main() {
	fmt.Println("fourSum([]int{1, 0, -1, 0, -2, 2}, 0) = ", fourSum([]int{1, 0, -1, 0, -2, 2}, 0))
}

func fourSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	le := len(nums)
	result := make([][]int, 0)
	for s := 0; s < le-3; s++ {
		if s > 0 && nums[s] == nums[s-1] {
			continue
		}
		for w := s + 1; w < le-2; w++ {
			if w > s+1 && nums[w] == nums[w-1] {
				continue
			}
			sw := nums[s] + nums[w]
			c, y := w+1, le-1
			for c < y {
				if swcy := sw + nums[c] + nums[y]; swcy == target {
					result = append(result, []int{nums[s], nums[w], nums[c], nums[y]})
					for c < y && nums[c] == nums[c+1] {
						c++
					}
					for y > c && nums[y] == nums[y-1] {
						y--
					}
					c++
					y--
				} else if swcy > target {
					for y > c && nums[y] == nums[y-1] {
						y--
					}
					y--
				} else {
					for c < y && nums[c] == nums[c+1] {
						c++
					}
					c++
				}
			}
		}
	}
	return result
}

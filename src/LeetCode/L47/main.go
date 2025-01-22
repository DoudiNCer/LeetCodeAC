package main

import (
	"fmt"
	"sort"
)

/*
*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],

	[1,2,1],
	[2,1,1]]

示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

提示：

- 1 <= nums.length <= 8
- -10 <= nums[i] <= 10
*/
func main() {
	fmt.Println("permuteUnique([]int{1, 1, 2}) = ", permuteUnique([]int{1, 1, 2}))
	fmt.Println("permuteUnique([]int{1, 2, 3}) = ", permuteUnique([]int{1, 2, 3}))
}

func permuteUnique(nums []int) [][]int {
	sort.Ints(nums)
	n := len(nums)
	if n == 1 {
		return [][]int{nums}
	}
	result := make([][]int, 0)
	cnts := make(map[int]int, n)
	for _, num := range nums {
		cnts[num]++
	}
	path := make([]int, 0, n)
	var bt func()
	bt = func() {
		le := len(path)
		if le == n {
			tmp := make([]int, n)
			copy(tmp, path)
			result = append(result, tmp)
			return
		}
		for i, num := range nums {
			if cnts[num] == 0 {
				continue
			}
			if i > 0 && num == nums[i-1] {
				continue
			}
			cnts[num]--
			path = append(path, num)
			bt()
			path = path[:le]
			cnts[num]++
		}
	}
	bt()
	return result
}

package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

示例 1：

输入：nums = [5,2,6,1]
输出：[2,1,1,0]
解释：
5 的右侧有 2 个更小的元素 (2 和 1)
2 的右侧仅有 1 个更小的元素 (1)
6 的右侧有 1 个更小的元素 (1)
1 的右侧有 0 个更小的元素
示例 2：

输入：nums = [-1]
输出：[0]
示例 3：

输入：nums = [-1,-1]
输出：[0,0]

提示：

- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
*/
func main() {
	fmt.Println("countSmaller([]int{5, 2, 6, 1}) = ",
		countSmaller([]int{5, 2, 6, 1}))
	fmt.Println("countSmaller([]int{-1}) = ", countSmaller([]int{-1}))
	fmt.Println("countSmaller([]int{-1, -1}) = ", countSmaller([]int{-1, -1}))
}

func countSmaller(nums []int) []int {
	n := len(nums)
	loc := make([]int, n)
	for i := range loc {
		loc[i] = i
	}
	sort.Slice(loc, func(i, j int) bool {
		li := loc[i]
		lj := loc[j]
		if nums[li] == nums[lj] {
			return li > lj
		}
		return nums[li] > nums[lj]
	})
	res := make([]int, n)
	ta := make([]int, n+1)
	for _, x := range loc {
		y := n - x
		c := 0
		for i := y; i > 0; i -= (i & (-i)) {
			c += ta[i]
		}
		res[x] = y - 1 - c
		for i := y; i <= n; i += (i & (-i)) {
			ta[i]++
		}
	}
	return res
}

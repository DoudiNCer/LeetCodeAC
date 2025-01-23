package main

import "fmt"

/*
*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
子集
（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]

提示：

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10
- nums 中的所有元素 互不相同
*/
func main() {
	fmt.Println("subsets([]int{1, 2, 3}) = ", subsets([]int{1, 2, 3}))
}

func subsets(nums []int) [][]int {
	n := len(nums)
	k := n
	result := make([][]int, 0)
	path := make([]int, 0, n)
	var rb func()
	rb = func() {
		k--
		le := len(path)
		if k == 0 {
			tmp := make([]int, le)
			copy(tmp, path)
			result = append(result, tmp)
			result = append(result, append([]int{nums[n-k-1]}, path...))
			k++
			return
		}
		rb()
		path = append(path, nums[n-k-1])
		rb()
		path = path[:le]
		k++
	}
	rb()
	return result
}

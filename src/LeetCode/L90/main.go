package main

import "fmt"

/*
*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的
子集
（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]

提示：

- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10
*/
func main() {
	fmt.Println("subsetsWithDup([]int{1, 2, 2}) = ", subsetsWithDup([]int{1, 2, 2}))
	fmt.Println("subsetsWithDup([]int{0}) = ", subsetsWithDup([]int{0}))
}

func subsetsWithDup(nums []int) [][]int {
	cnts := make(map[int]int)
	for _, num := range nums {
		cnts[num]++
	}
	n := len(cnts)
	nums = make([]int, 0, n)
	for k, _ := range cnts {
		nums = append(nums, k)
	}
	k := 0
	result := make([][]int, 0)
	path := make([]int, 0)
	var rb func()
	rb = func() {
		le := len(path)
		if k == n {
			tmp := make([]int, le)
			copy(tmp, path)
			result = append(result, tmp)
			return
		}
		k++
		num := nums[k]
		cnt := cnts[num]
		rb()
		for i := 0; i < cnt; i++ {
			path = append(path, num)
			rb()
		}
		path = path[:le]
		k--
	}
	rb()
	return result
}

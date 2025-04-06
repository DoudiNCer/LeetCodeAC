package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
answer[i] % answer[j] == 0 ，或
answer[j] % answer[i] == 0
如果存在多个有效解子集，返回其中任何一个均可。

示例 1：

输入：nums = [1,2,3]
输出：[1,2]
解释：[1,3] 也会被视为正确答案。
示例 2：

输入：nums = [1,2,4,8]
输出：[1,2,4,8]

提示：

- 1 <= nums.length <= 1000
- 1 <= nums[i] <= 2 * 10^9
*/
func main() {
	fmt.Println("largestDivisibleSubset([]int{1, 2, 3}) = ",
		largestDivisibleSubset([]int{1, 2, 3}))
	fmt.Println("largestDivisibleSubset([]int{1, 2, 4, 8}) = ",
		largestDivisibleSubset([]int{1, 2, 4, 8}))
}

func largestDivisibleSubset(nums []int) []int {
	sort.Ints(nums)
	n := len(nums)
	dp := make([][2]int, n+1)
	var mx int
	for j := 1; j < n; j++ {
		var exist bool
		for i := 0; i < j; i++ {
			if nums[j]%nums[i] != 0 {
				continue
			}
			exist = true
			if dp[i+1][1] >= dp[dp[j+1][0]][1] {
				dp[j+1][0] = i + 1
			}
		}
		if exist {
			dp[j+1][1] = dp[dp[j+1][0]][1] + 1
		}
		if dp[mx][1] < dp[j+1][1] {
			mx = j + 1
		}
	}
	res := make([]int, 0)
	for mx > 0 {
		res = append(res, nums[mx-1])
		mx = dp[mx][0]
	}
	if len(res) == 0 {
		res = append(res, nums[0])
	}
	return res
}

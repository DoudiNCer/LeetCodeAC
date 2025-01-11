package main

import "fmt"

/*
*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。

提示：

- 1 <= nums.length <= 200
- 1 <= nums[i] <= 100
*/
func main() {
	fmt.Println("canPartition([]int{2, 2, 3, 5}) = ", canPartition([]int{2, 2, 3, 5}))
}

func canPartition(nums []int) bool {
	target := 0
	max := 0
	for _, num := range nums {
		target += num
		if max < num {
			max = num
		}
	}

	if target&1 == 1 {
		return false
	}
	target /= 2
	if max > target {
		return false
	}
	dp := make([]bool, target+1)
	dp[0] = true
	for _, num := range nums {
		for i := target; i > num; i-- {
			dp[i] = dp[i-num] || dp[i]
		}
		dp[num] = true
	}
	return dp[target]
}

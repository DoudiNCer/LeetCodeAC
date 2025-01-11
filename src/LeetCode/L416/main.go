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
	le := len(nums)
	if le == 1 {
		return false
	}
	max, sum := 0, 0
	for _, num := range nums {
		sum += num
		if num > max {
			max = num
		}
	}
	if sum&1 != 0 {
		return false
	}
	sum >>= 1
	if max > sum {
		return false
	}
	if sum == max {
		return true
	}
	dp := make([][]bool, le)
	for i := 0; i < le; i++ {
		dp[i] = make([]bool, sum+1)
		dp[i][0] = true
	}
	dp[0][nums[0]] = true
	for i := 1; i < le; i++ {
		v := nums[i]
		for j := 1; j <= sum; j++ {
			if j >= v {
				dp[i][j] = dp[i-1][j] || dp[i-1][j-v]
			} else {
				dp[i][j] = dp[i-1][j]
			}
		}
	}
	return dp[le-1][sum]
}

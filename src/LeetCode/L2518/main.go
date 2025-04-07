package main

import (
	"fmt"
)

/*
*
给你一个正整数数组 nums 和一个整数 k 。

分区 的定义是：将数组划分成两个有序的 组 ，并满足每个元素 恰好 存在于 某一个 组中。如果分区中每个组的元素和都大于等于 k ，则认为分区是一个好分区。

返回 不同 的好分区的数目。由于答案可能很大，请返回对 10^9 + 7 取余 后的结果。

如果在两个分区中，存在某个元素 nums[i] 被分在不同的组中，则认为这两个分区不同。

示例 1：

输入：nums = [1,2,3,4], k = 4
输出：6
解释：好分区的情况是 ([1,2,3], [4]), ([1,3], [2,4]), ([1,4], [2,3]), ([2,3], [1,4]), ([2,4], [1,3]) 和 ([4], [1,2,3]) 。
示例 2：

输入：nums = [3,3,3], k = 4
输出：0
解释：数组中不存在好分区。
示例 3：

输入：nums = [6,6], k = 2
输出：2
解释：可以将 nums[0] 放入第一个分区或第二个分区中。
好分区的情况是 ([6], [6]) 和 ([6], [6]) 。

提示：

- 1 <= nums.length, k <= 1000
- 1 <= nums[i] <= 10^9
*/
func main() {
	fmt.Println("countPartitions([]int{1, 2, 3, 4}, 4) = ", countPartitions([]int{1, 2, 3, 4}, 4))
	fmt.Println("countPartitions([]int{3, 3, 3}, 4) = ", countPartitions([]int{3, 3, 3}, 4))
	fmt.Println("countPartitions([]int{6, 6}, 2) = ", countPartitions([]int{6, 6}, 2))
	fmt.Println("countPartitions([]int{73, 16, 86, 25, 98, 92, 15, 11, 87, 88, 88, 94, 83, 74, 1, 48, 91, 9, 45}, 61) = ",
		countPartitions([]int{73, 16, 86, 25, 98, 92, 15, 11, 87, 88, 88, 94, 83, 74, 1, 48, 91, 9, 45}, 61))
}

const MOD = 1000000007

func countPartitions(nums []int, k int) int {
	if len(nums) < 2 {
		return 0
	}
	sum := 0
	for _, num := range nums {
		sum += num
	}
	if sum < (k << 1) {
		return 0
	}
	res := 0
	dp := make([]int, k)
	dp[0] = 1
	for _, num := range nums {
		res <<= 1
		res %= MOD
		for c := k - 1; c >= num; c-- {
			dp[c] += dp[c-num]
			dp[c] %= MOD
		}
	}
	for _, c := range dp {
		res -= (c << 1)
	}
	return (res%MOD + MOD) % MOD
}

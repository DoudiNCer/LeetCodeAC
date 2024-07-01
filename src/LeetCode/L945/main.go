package main

import (
	"fmt"
	"sort"
)

/*
给你一个整数数组 nums 。每次 move 操作将会选择任意一个满足 0 <= i < nums.length 的下标 i，并将 nums[i] 递增 1。

返回使 nums 中的每个值都变成唯一的所需要的最少操作次数。

示例 1：

输入：nums = [1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
示例 2：

输入：nums = [3,2,1,2,1,7]
输出：6
解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。

提示：
- 1 <= nums.length <= 10^5
- 0 <= nums[i] <= 10^5
*/
func main() {
	fmt.Println("minIncrementForUnique([]int{1,2,2}) = ", minIncrementForUnique([]int{1, 2, 2}))
	fmt.Println("minIncrementForUnique([]int{3,2,1,2,1,7}) = ", minIncrementForUnique([]int{3, 2, 1, 2, 1, 7}))
}

func minIncrementForUnique(nums []int) int {
	sort.Ints(nums)
	var tys, cnts []int
	{
		ln := -1
		p := -1
		for _, num := range nums {
			if num != ln {
				tys = append(tys, num)
				cnts = append(cnts, 1)
				p++
				ln = num
			} else {
				cnts[p]++
			}
		}
	}
	var result = 0
	le := len(cnts) - 1
	for i := 0; i < le; i++ {
		fmt.Println("i = ", i)
		if cnts[i] <= tys[i+1]-tys[i] {
			result += (cnts[i] - 1) * (cnts[i]) / 2
		} else {
			ok := tys[i+1] - tys[i] - 1
			nok := cnts[i] - (tys[i+1] - tys[i])
			result += ok * (ok + 1) / 2
			result += nok * (tys[i+1] - tys[i])
			cnts[i+1] += nok
		}
	}
	result += (cnts[le] - 1) * cnts[le] / 2
	return result
}

package main

import "fmt"

/*
*
给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k 。每一次操作中，你可以选择一个数并将它乘 2 。

你最多可以进行 k 次操作，请你返回 nums[0] | nums[1] | ... | nums[n - 1] 的最大值。

a | b 表示两个整数 a 和 b 的 按位或 运算。

示例 1：

输入：nums = [12,9], k = 1
输出：30
解释：如果我们对下标为 1 的元素进行操作，新的数组为 [12,18] 。此时得到最优答案为 12 和 18 的按位或运算的结果，也就是 30 。
示例 2：

输入：nums = [8,1,2], k = 2
输出：35
解释：如果我们对下标 0 处的元素进行操作，得到新数组 [32,1,2] 。此时得到最优答案为 32|1|2 = 35 。

提示：

- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^9
- 1 <= k <= 15
*/
func main() {
	fmt.Println("maximumOr([]int{12, 9}, 1) = ", maximumOr([]int{12, 9}, 1))
	fmt.Println("maximumOr([]int{8, 1, 2}, 2) = ", maximumOr([]int{8, 1, 2}, 2))
}

func maximumOr(nums []int, k int) int64 {
	n := len(nums)
	fix := make([][]int, 2)
	fix[0] = make([]int, n)
	fix[1] = make([]int, n)
	for i, f := 0, 0; i < n; i++ {
		fix[0][i] = f
		f |= nums[i]
	}
	for i, f := n-1, 0; i >= 0; i-- {
		fix[1][i] = f
		f |= nums[i]
	}
	res := int64(0)
	for i := 0; i < n; i++ {
		r := int64(nums[i]) << k
		r |= int64(fix[0][i])
		r |= int64(fix[1][i])
		if r > res {
			res = r
		}
	}
	return res
}

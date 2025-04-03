package main

import "fmt"

/*
*
给你一个下标从 0 开始的整数数组 nums 。

请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。

下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。

示例 1：

输入：nums = [12,6,1,2,7]
输出：77
解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
可以证明不存在值大于 77 的有序下标三元组。
示例 2：

输入：nums = [1,10,3,4,19]
输出：133
解释：下标三元组 (1, 2, 4) 的值是 (nums[1] - nums[2]) * nums[4] = 133 。
可以证明不存在值大于 133 的有序下标三元组。
示例 3：

输入：nums = [1,2,3]
输出：0
解释：唯一的下标三元组 (0, 1, 2) 的值是一个负数，(nums[0] - nums[1]) * nums[2] = -3 。因此，答案是 0 。

提示：

- 3 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^6
*/
func main() {
	fmt.Println("maximumTripletValue([]int{12, 6, 1, 2, 7}) = ",
		maximumTripletValue([]int{12, 6, 1, 2, 7}))
	fmt.Println("maximumTripletValue([]int{1, 10, 3, 4, 19}) = ",
		maximumTripletValue([]int{1, 10, 3, 4, 19}))
	fmt.Println("maximumTripletValue([]int{1, 2, 3}) = ",
		maximumTripletValue([]int{1, 2, 3}))
}

func maximumTripletValue(nums []int) int64 {
	n := len(nums)
	ms := make([]int, n-1)
	for i, m := n-2, nums[n-1]; i >= 0; i-- {
		ms[i] = m
		if nums[i] > m {
			m = nums[i]
		}
	}
	res := int64(0)
	for i, m := 1, nums[0]; i < n-1; i++ {
		r := int64(m - nums[i])
		if nums[i] > m {
			m = nums[i]
		}
		if r < 0 {
			continue
		}
		r *= int64(ms[i])
		if r > res {
			res = r
		}
	}
	return res
}

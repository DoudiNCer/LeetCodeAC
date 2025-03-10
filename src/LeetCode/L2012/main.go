package main

import "fmt"

/*
*
给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：

2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
0，如果上述条件全部不满足
返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。

示例 1：

输入：nums = [1,2,3]
输出：2
解释：对于每个符合范围 1 <= i <= 1 的下标 i :
- nums[1] 的美丽值等于 2
示例 2：

输入：nums = [2,4,6,4]
输出：1
解释：对于每个符合范围 1 <= i <= 2 的下标 i :
- nums[1] 的美丽值等于 1
- nums[2] 的美丽值等于 0
示例 3：

输入：nums = [3,2,1]
输出：0
解释：对于每个符合范围 1 <= i <= 1 的下标 i :
- nums[1] 的美丽值等于 0

提示：

3 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
*/
func main() {
	fmt.Println("sumOfBeauties([]int{1, 2, 3}) = ", sumOfBeauties([]int{1, 2, 3}))
	fmt.Println("sumOfBeauties([]int{2, 4, 6, 4}) = ", sumOfBeauties([]int{2, 4, 6, 4}))
}

func sumOfBeauties(nums []int) int {
	n := len(nums)
	mins := make([]int, n)

	for i, min := n-1, nums[n-1]; i >= 0; i-- {
		mins[i] = min
		if min > nums[i] {
			min = nums[i]
		}
	}
	res := 0
	for i, max := 1, nums[0]; i < n-1; i++ {
		if max < nums[i] && nums[i] < mins[i] {
			res += 2
		} else if nums[i-1] < nums[i] && nums[i] < nums[i+1] {
			res++
		}
		if max < nums[i] {
			max = nums[i]
		}
	}
	return res
}

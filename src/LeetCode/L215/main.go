package main

import "fmt"

/*
*
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

示例 1:

输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4

提示：

- 1 <= k <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
*/
func main() {
	fmt.Println("findKthLargest([]int{3, 2, 1, 5, 6, 4}, 2) = ", findKthLargest([]int{3, 2, 1, 5, 6, 4}, 2))
}

func findKthLargest(nums []int, k int) int {
	n := len(nums)
	return quickselect(nums, 0, n-1, n-k)
}

func quickselect(nums []int, l, r, k int) int {
	if l == r {
		return nums[k]
	}
	i, j, p := l-1, r+1, nums[l]
	for i < j {
		for i++; nums[i] < p; i++ {

		}
		for j--; nums[j] > p; j-- {

		}

		if i < j {
			nums[i], nums[j] = nums[j], nums[i]
		}
	}
	if k <= j {
		return quickselect(nums, l, j, k)
	} else {
		return quickselect(nums, j+1, r, k)
	}
}

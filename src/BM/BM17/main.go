package main

import "fmt"

/*
请实现无重复数字的升序数组的二分查找

给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1

数据范围：0≤len(nums)≤2×10^5， 数组中任意值满足∣val∣≤10^9

进阶：时间复杂度O(logn) ，空间复杂度O(1)
*/
func main() {
	fmt.Println("search([]int{1, 1}, 0) = ", search([]int{1, 1}, 0))
}

func search(nums []int, target int) int {
	l, r := 0, len(nums)-1
	if l > r {
		return -1
	}
	if target < nums[0] || target > nums[r] {
		return -1
	}
	if target == nums[l] {
		return l
	}
	if target == nums[r] {
		return r
	}
	for l != r {
		m := (l + r) / 2
		if nums[m] == target {
			return m
		} else if nums[m] < target {
			if l == m {
				return -1
			}
			l = m
		} else {
			if r == m {
				return -1
			}
			r = m
		}
	}
	return -1
}

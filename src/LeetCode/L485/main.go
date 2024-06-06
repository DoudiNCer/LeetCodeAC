package main

import "fmt"

/*
给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。

示例 1：

输入：nums = [1,1,0,1,1,1]
输出：3
解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
示例 2:

输入：nums = [1,0,1,1,0,1]
输出：2

提示：

- 1 <= nums.length <= 10^5
- nums[i] 不是 0 就是 1.
*/
func main() {
	fmt.Println("findMaxConsecutiveOnes([]int{1, 1, 0, 1, 1, 1}) = ", findMaxConsecutiveOnes([]int{1, 1, 0, 1, 1, 1}))
}

func findMaxConsecutiveOnes(nums []int) int {
	result := 0
	cnt := 0
	for _, num := range nums {
		switch num {
		case 0:
			if result < cnt {
				result = cnt
			}
			cnt = 0
		case 1:
			cnt++
		}
	}
	if result < cnt {
		result = cnt
	}
	return result
}

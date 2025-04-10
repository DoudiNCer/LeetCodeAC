package main

import "fmt"

/*
*
给你一个由 正 整数组成的数组 nums 。

如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。

返回 最长 的优雅子数组的长度。

子数组 是数组中的一个 连续 部分。

注意：长度为 1 的子数组始终视作优雅子数组。

示例 1：

输入：nums = [1,3,8,48,10]
输出：3
解释：最长的优雅子数组是 [3,8,48] 。子数组满足题目条件：
- 3 AND 8 = 0
- 3 AND 48 = 0
- 8 AND 48 = 0
可以证明不存在更长的优雅子数组，所以返回 3 。
示例 2：

输入：nums = [3,1,5,11,13]
输出：1
解释：最长的优雅子数组长度为 1 ，任何长度为 1 的子数组都满足题目条件。

提示：

- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^9
*/
func main() {
	fmt.Println("longestNiceSubarray([]int{1, 3, 8, 48, 10}) = ", longestNiceSubarray([]int{1, 3, 8, 48, 10}))
	fmt.Println("longestNiceSubarray([]int{3, 1, 5, 11, 13}) = ", longestNiceSubarray([]int{3, 1, 5, 11, 13}))
}

func longestNiceSubarray(nums []int) int {
	n := len(nums)
	res := 1
	for l, r := 0, 1; l < n; {
		for r < n {
			ok := true
			for i := l; i < r; i++ {
				if nums[i]&nums[r] != 0 {
					ok = false
					break
				}
			}
			if ok {
				r++
			} else {
				break
			}
		}
		if r-l > res {
			res = r - l
		}
		l++
	}
	return res
}

package main

import (
	"fmt"
)

/*
给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。

子数组 是数组的 连续 部分。

示例 1：

输入：nums = [4,5,0,-2,-3,1], k = 5
输出：7
解释：
有 7 个子数组满足其元素之和可被 k = 5 整除：
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
示例 2:

输入: nums = [5], k = 9
输出: 0

提示:

- 1 <= nums.length <= 3 * 10^4
- -10^4 <= nums[i] <= 10^4
- 2 <= k <= 10^4
*/
func main() {
	fmt.Println("subarraysDivByK([]int{4, 5, 0, -2, -3, 1}, 5) = ", subarraysDivByK([]int{4, 5, 0, -2, -3, 1}, 5))
}

func subarraysDivByK(nums []int, k int) int {
	le := len(nums)
	cnts := make(map[int]int)
	cnts[rem(nums[0], k)]++
	for i := 1; i < le; i++ {
		nums[i] = rem(nums[i-1]+nums[i], k)
		cnts[nums[i]]++
	}
	var result int
	result += cnts[0]
	for _, cnt := range cnts {
		var rp int64 = int64(cnt)
		rp *= int64(cnt - 1)
		rp /= 2
		result += int(rp)
	}
	return result
}

func rem(a, k int) int {
	a %= k
	if a < 0 {
		a += k
	}
	return a
}

package main

import "fmt"

/*
给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。



示例 1：

输入：nums = [2,2,3,2]
输出：3
示例 2：

输入：nums = [0,1,0,1,0,1,99]
输出：99


提示：

- 1 <= nums.length <= 3 * 10^4
- -2^31 <= nums[i] <= 2^31 - 1
- nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
*/

func main() {
	fmt.Println("singleNumber([]int{0,1,0,1,0,1,99}) = ", singleNumber([]int{0, 1, 0, 1, 0, 1, 99}))
}

func singleNumber(nums []int) int {
	ans := int32(0)
	for i := 0; i < 32; i++ {
		total := int32(0)
		for _, num := range nums {
			total += int32(num) >> i & 1
		}
		if total%3 > 0 {
			ans |= 1 << i
		}
	}
	return int(ans)
}

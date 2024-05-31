package main

import (
	"fmt"
	"math"
)

/*
给你一个正整数数组 nums ，对 nums 所有元素求积之后，找出并返回乘积中 不同质因数 的数目。

注意：

质数 是指大于 1 且仅能被 1 及自身整除的数字。
如果 val2 / val1 是一个整数，则整数 val1 是另一个整数 val2 的一个因数。

示例 1：

输入：nums = [2,4,3,7,10,6]
输出：4
解释：
nums 中所有元素的乘积是：2 * 4 * 3 * 7 * 10 * 6 = 10080 = 25 * 32 * 5 * 7 。
共有 4 个不同的质因数，所以返回 4 。
示例 2：

输入：nums = [2,4,8,16]
输出：1
解释：
nums 中所有元素的乘积是：2 * 4 * 8 * 16 = 1024 = 210 。
共有 1 个不同的质因数，所以返回 1 。

提示：

- 1 <= nums.length <= 10^4
- 2 <= nums[i] <= 1000
*/
func main() {
	ps := getPrimes(1000)
	for _, p := range ps {
		fmt.Print(p, ", ")
	}
	fmt.Println()
	fmt.Println("distinctPrimeFactors([]int{2,4,3,7,10,6}) = ", distinctPrimeFactors([]int{2, 4, 3, 7, 10, 6}))
}

func distinctPrimeFactors(nums []int) int {
	primes := getPrimes(1000)
	result := 0
	pms := map[int]struct{}{}
	for _, num := range nums {
		for _, prime := range primes {
			if prime > num {
				break
			}
			if num%prime == 0 {
				if _, ok := pms[prime]; !ok {
					pms[prime] = struct{}{}
					result++
				}
			}
		}
	}
	return result
}

func getPrimes(maxp int) []int {
	var result []int
	for i := 2; i <= maxp; i++ {
		zhi := true
		mx := int(math.Sqrt(float64(i))) + 1
		for x := 2; x < mx; x++ {
			if i%x == 0 {
				zhi = false
				break
			}
		}
		if zhi {
			result = append(result, i)
		}
	}
	return result
}

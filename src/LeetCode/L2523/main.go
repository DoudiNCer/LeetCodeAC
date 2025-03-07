package main

import "fmt"

/*
*
给你两个正整数 left 和 right ，请你找到两个整数 num1 和 num2 ，它们满足：

left <= nums1 < nums2 <= right  。
nums1 和 nums2 都是 质数 。
nums2 - nums1 是满足上述条件的质数对中的 最小值 。
请你返回正整数数组 ans = [nums1, nums2] 。如果有多个整数对满足上述条件，请你返回 nums1 最小的质数对。如果不存在符合题意的质数对，请你返回 [-1, -1] 。

示例 1：

输入：left = 10, right = 19
输出：[11,13]
解释：10 到 19 之间的质数为 11 ，13 ，17 和 19 。
质数对的最小差值是 2 ，[11,13] 和 [17,19] 都可以得到最小差值。
由于 11 比 17 小，我们返回第一个质数对。
示例 2：

输入：left = 4, right = 6
输出：[-1,-1]
解释：给定范围内只有一个质数，所以题目条件无法被满足。

提示：

- 1 <= left <= right <= 10^6
*/
func main() {
	fmt.Println("closestPrimes(10, 19) = ", closestPrimes(10, 19))
	fmt.Println("closestPrimes(999998, 1000000) = ", closestPrimes(999998, 1000000))
}

var prime = []int{}

func init() {
	var composite = [1000000]bool{}
	var found = 2
	n := 999999
	for found <= n {
		if composite[found] {
			found++
			continue
		}
		prime = append(prime, found)
		for i := found * 2; i <= n; i += found {
			composite[i] = true
		}
		found++
	}
}

func closestPrimes(left int, right int) []int {
	l := 0
	for i := range prime {
		if prime[i] >= left {
			l = i
			break
		}
	}
	p := l + 1
	if p >= len(prime) || prime[p] > right || prime[l] < left {
		return []int{-1, -1}
	}
	minl := prime[p] - prime[p-1]

	for p < len(prime) && prime[p] <= right {
		if prime[p]-prime[p-1] < minl {
			minl = prime[p] - prime[p-1]
			l = p - 1
		}
		p++
	}
	return []int{prime[l], prime[l+1]}
}

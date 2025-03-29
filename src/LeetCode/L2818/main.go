package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个长度为 n 的正整数数组 nums 和一个整数 k 。

一开始，你的分数为 1 。你可以进行以下操作至多 k 次，目标是使你的分数最大：

选择一个之前没有选过的 非空 子数组 nums[l, ..., r] 。
从 nums[l, ..., r] 里面选择一个 质数分数 最高的元素 x 。如果多个元素质数分数相同且最高，选择下标最小的一个。
将你的分数乘以 x 。
nums[l, ..., r] 表示 nums 中起始下标为 l ，结束下标为 r 的子数组，两个端点都包含。

一个整数的 质数分数 等于 x 不同质因子的数目。比方说， 300 的质数分数为 3 ，因为 300 = 2 * 2 * 3 * 5 * 5 。

请你返回进行至多 k 次操作后，可以得到的 最大分数 。

由于答案可能很大，请你将结果对 109 + 7 取余后返回。

示例 1：

输入：nums = [8,3,9,3,8], k = 2
输出：81
解释：进行以下操作可以得到分数 81 ：
- 选择子数组 nums[2, ..., 2] 。nums[2] 是子数组中唯一的元素。所以我们将分数乘以 nums[2] ，分数变为 1 * 9 = 9 。
- 选择子数组 nums[2, ..., 3] 。nums[2] 和 nums[3] 质数分数都为 1 ，但是 nums[2] 下标更小。所以我们将分数乘以 nums[2] ，分数变为 9 * 9 = 81 。
81 是可以得到的最高得分。
示例 2：

输入：nums = [19,12,14,6,10,18], k = 3
输出：4788
解释：进行以下操作可以得到分数 4788 ：
- 选择子数组 nums[0, ..., 0] 。nums[0] 是子数组中唯一的元素。所以我们将分数乘以 nums[0] ，分数变为 1 * 19 = 19 。
- 选择子数组 nums[5, ..., 5] 。nums[5] 是子数组中唯一的元素。所以我们将分数乘以 nums[5] ，分数变为 19 * 18 = 342 。
- 选择子数组 nums[2, ..., 3] 。nums[2] 和 nums[3] 质数分数都为 2，但是 nums[2] 下标更小。所以我们将分数乘以 nums[2] ，分数变为  342 * 14 = 4788 。
4788 是可以得到的最高的分。

提示：

- 1 <= nums.length == n <= 10^5
- 1 <= nums[i] <= 10^5
- 1 <= k <= min(n * (n + 1) / 2, 10^9)
*/
func main() {
	fmt.Println("maximumScore([]int{8, 3, 9, 3, 8}, 2) = ",
		maximumScore([]int{8, 3, 9, 3, 8}, 2))
	fmt.Println("maximumScore([]int{19, 12, 14, 6, 10, 18}, 3) = ",
		maximumScore([]int{19, 12, 14, 6, 10, 18}, 3))
	fmt.Println("maximumScore([]int{3289, 2832, 14858, 22011}, 6) = ",
		maximumScore([]int{3289, 2832, 14858, 22011}, 6))
}

var prime = []int{}

func init() {
	var composite = [10000]bool{}
	var found = 2
	n := 9999
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

const MOD uint64 = 1e9 + 7

func maximumScore(nums []int, k int) int {
	n := len(nums)
	scores := make([]int, n)
	ps := make([]int, n)
	lm, rm := make([]int, n), make([]int, n)
	for i, num := range nums {
		scores[i] = score(num)
		ps[i] = i
		lm[i] = -1
		rm[i] = n
	}
	sort.Slice(ps, func(i, j int) bool {
		return nums[ps[i]] > nums[ps[j]]
	})
	{
		stack := make([]int, 0)
		for i := 0; i < n; i++ {
			for len(stack) > 0 && scores[stack[len(stack)-1]] < scores[i] {
				rm[stack[len(stack)-1]] = i
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, i)
		}
		stack = make([]int, 0)
		for i := n - 1; i >= 0; i-- {
			for len(stack) > 0 && scores[stack[len(stack)-1]] <= scores[i] {
				lm[stack[len(stack)-1]] = i
				stack = stack[:len(stack)-1]
			}
			stack = append(stack, i)
		}
	}
	res := uint64(1)
	for _, p := range ps {
		cnt := (p - lm[p]) * (rm[p] - p)
		if cnt > k {
			cnt = k
		}
		res %= MOD
		res *= pow(uint64(nums[p]), uint64(cnt))
		k -= cnt
		if k == 0 {
			break
		}
	}
	return int(res % MOD)
}

func pow(b, e uint64) uint64 {
	b %= MOD
	res := uint64(1)
	for e > 0 {
		if e&1 == 1 {
			res = (res * b) % MOD
		}
		b = (b * b) % MOD
		e >>= 1
	}
	return res
}

var smap = map[int]int{
	0: 0,
	1: 0,
	2: 1,
}

func score(num int) int {
	if s, ok := smap[num]; ok {
		return s
	}
	s := 0
	for _, p := range prime {
		if p > num {
			break
		}
		if num%p == 0 {
			s++
		}
	}
	smap[num] = s
	return s
}

package main

import (
	"fmt"
	"sort"
)

/*
*
我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：

如果 x 是偶数，那么 x = x / 2
如果 x 是奇数，那么 x = 3 * x + 1
比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。

给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。

请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。

注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。

示例 1：

输入：lo = 12, hi = 15, k = 2
输出：13
解释：12 的权重为 9（12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）
13 的权重为 9
14 的权重为 17
15 的权重为 17
区间内的数按权重排序以后的结果为 [12,13,14,15] 。对于 k = 2 ，答案是第二个整数也就是 13 。
注意，12 和 13 有相同的权重，所以我们按照它们本身升序排序。14 和 15 同理。
示例 2：

输入：lo = 7, hi = 11, k = 4
输出：7
解释：区间内整数 [7, 8, 9, 10, 11] 对应的权重为 [16, 3, 19, 6, 14] 。
按权重排序后得到的结果为 [8, 10, 11, 7, 9] 。
排序后数组中第 4 个数字为 7 。

提示：

- 1 <= lo <= hi <= 1000
- 1 <= k <= hi - lo + 1
*/
func main() {
	fmt.Println("getKth(12, 15, 2) = ", getKth(12, 15, 2))
	fmt.Println("getKth(7, 11, 4) = ", getKth(7, 11, 4))
}

var weight map[int]int = map[int]int{
	1: 0,
}

func getWeight(a int) int {
	w, exist := weight[a]
	if exist {
		return w
	}
	if a&1 == 0 {
		w = getWeight(a>>1) + 1
	} else {
		w = getWeight(a*3+1) + 1
	}
	weight[a] = w
	return w
}

func getKth(lo int, hi int, k int) int {
	le := hi - lo + 1
	nums := make([]int, hi-lo+1)
	for i := 0; i < le; i++ {
		nums[i] = lo + i
	}
	sort.Slice(nums, func(i, j int) bool {
		wi, wj := getWeight(nums[i]), getWeight(nums[j])
		if wi != wj {
			return wi < wj
		}
		return nums[i] < nums[j]
	})
	return nums[k-1]
}

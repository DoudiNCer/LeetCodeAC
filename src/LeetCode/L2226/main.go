package main

import "fmt"

/*
*
给你一个 下标从 0 开始 的整数数组 candies 。数组中的每个元素表示大小为 candies[i] 的一堆糖果。你可以将每堆糖果分成任意数量的 子堆 ，但 无法 再将两堆合并到一起。

另给你一个整数 k 。你需要将这些糖果分配给 k 个小孩，使每个小孩分到 相同 数量的糖果。每个小孩可以拿走 至多一堆 糖果，有些糖果可能会不被分配。

返回每个小孩可以拿走的 最大糖果数目 。

示例 1：

输入：candies = [5,8,6], k = 3
输出：5
解释：可以将 candies[1] 分成大小分别为 5 和 3 的两堆，然后把 candies[2] 分成大小分别为 5 和 1 的两堆。现在就有五堆大小分别为 5、5、3、5 和 1 的糖果。可以把 3 堆大小为 5 的糖果分给 3 个小孩。可以证明无法让每个小孩得到超过 5 颗糖果。
示例 2：

输入：candies = [2,5], k = 11
输出：0
解释：总共有 11 个小孩，但只有 7 颗糖果，但如果要分配糖果的话，必须保证每个小孩至少能得到 1 颗糖果。因此，最后每个小孩都没有得到糖果，答案是 0 。

提示：

- 1 <= candies.length <= 10^5
- 1 <= candies[i] <= 10^7
- 1 <= k <= 10^12
*/
func main() {
	fmt.Println("maximumCandies([]int{5, 8, 6}, 3) = ", maximumCandies([]int{5, 8, 6}, 3))
	fmt.Println("maximumCandies([]int{2, 5}, 11) = ", maximumCandies([]int{2, 5}, 11))
}

func maximumCandies(candies []int, k int64) int {
	maxc := candies[0]
	{
		sum := int64(0)
		for _, c := range candies {
			sum += int64(c)
			if c > maxc {
				maxc = c
			}
		}
		if sum < k {
			return 0
		} else if sum == k {
			return 1
		}
	}
	res := 1
	for l, r := 1, maxc; l <= r; {
		m := l + (r-l)/2
		kk := k
		for _, c := range candies {
			kk -= int64(c / m)
		}
		if kk <= 0 {
			if res < m {
				res = m
			}
			l = m + 1
		} else {
			r = m - 1
		}
	}
	return res
}

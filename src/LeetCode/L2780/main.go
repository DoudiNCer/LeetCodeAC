package main

import "fmt"

/*
*
如果在长度为 m 的整数数组 arr 中 超过一半 的元素值为 x，那么我们称 x 是 支配元素 。

给你一个下标从 0 开始长度为 n 的整数数组 nums ，数据保证它含有一个 支配 元素。

你需要在下标 i 处将 nums 分割成两个数组 nums[0, ..., i] 和 nums[i + 1, ..., n - 1] ，如果一个分割满足以下条件，我们称它是 合法 的：

0 <= i < n - 1
nums[0, ..., i] 和 nums[i + 1, ..., n - 1] 的支配元素相同。
这里， nums[i, ..., j] 表示 nums 的一个子数组，它开始于下标 i ，结束于下标 j ，两个端点都包含在子数组内。特别地，如果 j < i ，那么 nums[i, ..., j] 表示一个空数组。

请你返回一个 合法分割 的 最小 下标。如果合法分割不存在，返回 -1 。

示例 1：

输入：nums = [1,2,2,2]
输出：2
解释：我们将数组在下标 2 处分割，得到 [1,2,2] 和 [2] 。
数组 [1,2,2] 中，元素 2 是支配元素，因为它在数组中出现了 2 次，且 2 * 2 > 3 。
数组 [2] 中，元素 2 是支配元素，因为它在数组中出现了 1 次，且 1 * 2 > 1 。
两个数组 [1,2,2] 和 [2] 都有与 nums 一样的支配元素，所以这是一个合法分割。
下标 2 是合法分割中的最小下标。
示例 2：

输入：nums = [2,1,3,1,1,1,7,1,2,1]
输出：4
解释：我们将数组在下标 4 处分割，得到 [2,1,3,1,1] 和 [1,7,1,2,1] 。
数组 [2,1,3,1,1] 中，元素 1 是支配元素，因为它在数组中出现了 3 次，且 3 * 2 > 5 。
数组 [1,7,1,2,1] 中，元素 1 是支配元素，因为它在数组中出现了 3 次，且 3 * 2 > 5 。
两个数组 [2,1,3,1,1] 和 [1,7,1,2,1] 都有与 nums 一样的支配元素，所以这是一个合法分割。
下标 4 是所有合法分割中的最小下标。
示例 3：

输入：nums = [3,3,3,3,7,2,2]
输出：-1
解释：没有合法分割。

提示：

- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^9
- nums 有且只有一个支配元素。
*/
func main() {
	fmt.Println("minimumIndex([]int{1, 2, 2, 2}) = ", minimumIndex([]int{1, 2, 2, 2}))
	fmt.Println("minimumIndex([]int{2, 1, 3, 1, 1, 1, 7, 1, 2, 1}) = ", minimumIndex([]int{2, 1, 3, 1, 1, 1, 7, 1, 2, 1}))
	fmt.Println("minimumIndex([]int{3, 3, 3, 3, 7, 2, 2}) = ", minimumIndex([]int{3, 3, 3, 3, 7, 2, 2}))
}

func minimumIndex(nums []int) int {
	n := len(nums)
	doms := make([]int, n)
	domf := make(map[int]int)
	d, f := 0, 0
	dom := func(cnt int) int {
		if cnt == 0 {
			return -1
		}
		th := (cnt >> 1) + 1
		if f >= th {
			return d
		}
		return -1
	}
	for i := n - 1; i >= 0; i-- {
		doms[i] = dom(n - 1 - i)
		domf[nums[i]]++
		if domf[nums[i]] > f {
			f = domf[nums[i]]
			d = nums[i]
		}
	}
	domf = make(map[int]int)
	d, f = 0, 0
	for i := 0; i < n-1; i++ {
		domf[nums[i]]++
		if domf[nums[i]] > f {
			f = domf[nums[i]]
			d = nums[i]
		}
		if doms[i] == -1 {
			continue
		}
		if dom(i+1) == doms[i] {
			return i
		}
	}
	return -1
}

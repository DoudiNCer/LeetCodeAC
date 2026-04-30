package main

import "fmt"

/*
*
给你一个下标从 0 开始的数组 nums 和一个整数 target 。

下标从 0 开始的数组 infinite_nums 是通过无限地将 nums 的元素追加到自己之后生成的。

请你从 infinite_nums 中找出满足 元素和 等于 target 的 最短 子数组，并返回该子数组的长度。如果不存在满足条件的子数组，返回 -1 。

示例 1：

输入：nums = [1,2,3], target = 5
输出：2
解释：在这个例子中 infinite_nums = [1,2,3,1,2,3,1,2,...] 。
区间 [1,2] 内的子数组的元素和等于 target = 5 ，且长度 length = 2 。
可以证明，当元素和等于目标值 target = 5 时，2 是子数组的最短长度。
示例 2：

输入：nums = [1,1,1,2,3], target = 4
输出：2
解释：在这个例子中 infinite_nums = [1,1,1,2,3,1,1,1,2,3,1,1,...].
区间 [4,5] 内的子数组的元素和等于 target = 4 ，且长度 length = 2 。
可以证明，当元素和等于目标值 target = 4 时，2 是子数组的最短长度。
示例 3：

输入：nums = [2,4,6,8], target = 3
输出：-1
解释：在这个例子中 infinite_nums = [2,4,6,8,2,4,6,8,...] 。
可以证明，不存在元素和等于目标值 target = 3 的子数组。

提示：

- 1 <= nums.length <= 10^5
- 1 <= nums[i] <= 10^5
- 1 <= target <= 10^9
*/
func main() {
	fmt.Println("minSizeSubarray([]int{1, 2, 3}, 5) = ", minSizeSubarray([]int{1, 2, 3}, 5))
	fmt.Println("minSizeSubarray([]int{1, 1, 1, 2, 3}, 4) = ", minSizeSubarray([]int{1, 1, 1, 2, 3}, 4))
	fmt.Println("minSizeSubarray([]int{3, 6}, 66) = ", minSizeSubarray([]int{3, 6}, 66))
}

func minSizeSubarray(nums []int, target int) int {
	n := len(nums)
	prefix := make([]int, 0, n)
	prefix = append(prefix, nums[0])
	prefixMap := make(map[int]int, n)
	prefixMap[nums[0]] = 0
	for i := 1; i < n; i++ {
		prefix = append(prefix, nums[i]+prefix[i-1])
		prefixMap[prefix[i]] = i
	}
	row := target / prefix[n-1]
	target = target % prefix[n-1]
	res := n + 1
	// possible prefix
	if p, ok := prefixMap[target]; ok && res > p+1 {
		res = p + 1
	}
	// possible suffix
	if p, ok := prefixMap[prefix[n-1]-target]; ok && res > n-(p+1) {
		res = n - (p + 1)
	}
	// suffix[j] = prefix[n - 1] - prefix[j - 1], so j > 0
	for i := 0; i < n; i++ {
		// target == prefix[i] + suffix[j], answer = i + 1 + n - j
		if diff := target - prefix[i]; diff > 0 {
			if j, ok := prefixMap[prefix[n-1]-diff]; ok {
				j++
				res = min(res, i+1+n-j)
			}
		}
		// target = prefix[j] - prefix[i], answer = j - i
		if diff := target + prefix[i]; diff <= prefix[n-1] {
			if j, ok := prefixMap[diff]; ok {
				res = min(res, j-i)
			}
		}
	}
	if res == n+1 {
		return -1
	}
	return res + row*n
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

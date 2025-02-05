package main

import "fmt"

/*
*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。

示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3

	1 [3  -1  -3] 5  3  6  7       3
	1  3 [-1  -3  5] 3  6  7       5
	1  3  -1 [-3  5  3] 6  7       5
	1  3  -1  -3 [5  3  6] 7       6
	1  3  -1  -3  5 [3  6  7]      7

示例 2：

输入：nums = [1], k = 1
输出：[1]

提示：

- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
- 1 <= k <= nums.length
*/
func main() {
	fmt.Println("maxSlidingWindow([]int{1, 3, -1, -3, 5, 3, 6, 7}, 3) = ", maxSlidingWindow([]int{1, 3, -1, -3, 5, 3, 6, 7}, 3))
	fmt.Println("maxSlidingWindow([]int{1}, 1) = ", maxSlidingWindow([]int{1}, 1))
}

func maxSlidingWindow(nums []int, k int) []int {
	le := len(nums)
	result := make([]int, 0, le-k+1)
	queue := make([]int, 0)
	put := func(num int) {
		p := len(queue) - 1
		for p >= 0 && queue[p] < num {
			p--
		}
		queue = append(queue[:p+1], num)
	}
	rem := func(num int) {
		if len(queue) == 0 {
			return
		}
		if queue[0] == num {
			queue = queue[1:]
		}
	}
	for i := 0; i < k; i++ {
		put(nums[i])
	}
	result = append(result, queue[0])
	for i := k; i < le; i++ {
		rem(nums[i-k])
		put(nums[i])
		result = append(result, queue[0])
	}
	return result
}

package main

import "fmt"

/*
*
给你一个整数 n ，请你找到满足下面条件的一个序列：

整数 1 在序列中只出现一次。
2 到 n 之间每个整数都恰好出现两次。
对于每个 2 到 n 之间的整数 i ，两个 i 之间出现的距离恰好为 i 。
序列里面两个数 a[i] 和 a[j] 之间的 距离 ，我们定义为它们下标绝对值之差 |j - i| 。

请你返回满足上述条件中 字典序最大 的序列。题目保证在给定限制条件下，一定存在解。

一个序列 a 被认为比序列 b （两者长度相同）字典序更大的条件是： a 和 b 中第一个不一样的数字处，a 序列的数字比 b 序列的数字大。比方说，[0,1,9,0] 比 [0,1,5,6] 字典序更大，因为第一个不同的位置是第三个数字，且 9 比 5 大。

示例 1：

输入：n = 3
输出：[3,1,2,3,2]
解释：[2,3,2,1,3] 也是一个可行的序列，但是 [3,1,2,3,2] 是字典序最大的序列。
示例 2：

输入：n = 5
输出：[5,3,1,4,3,5,2,4,2]

提示：

- 1 <= n <= 20
*/
func main() {
	fmt.Println("constructDistancedSequence(3) = ",
		constructDistancedSequence(3))
	fmt.Println("constructDistancedSequence(5) = ",
		constructDistancedSequence(5))
}

func constructDistancedSequence(n int) []int {
	le := 2*n - 1
	used := make([]bool, n+1)
	result := make([]int, le)
	var dfs func(int, int) bool
	dfs = func(check, rp int) bool {
		if check < 1 {
			return true
		}
		for rp < le && result[rp] != 0 {
			rp++
		}
		if rp == le {
			return true
		}
		if check == 1 {
			result[rp] = 1
			return true
		}
		for c := check; c > 0; c-- {
			if used[c] {
				continue
			}
			if c > 1 && (rp+c >= le || result[rp+c] != 0) {
				continue
			}
			used[c] = true
			result[rp] = c
			if c > 1 {
				result[rp+c] = c
			}
			res := func(check int) bool {
				if c == check {
					return dfs(check-1, rp+1)
				} else {
					return dfs(check, rp+1)
				}
			}(check)
			if res {
				return true
			} else {
				used[c] = false
				result[rp] = 0
				if c > 1 {
					result[rp+c] = 0
				}
			}
		}
		return false
	}
	dfs(n, 0)
	return result
}

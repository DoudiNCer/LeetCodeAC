package main

import (
	"fmt"
	"sort"
)

/*
*
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。

示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]

提示:

- 1 <= candidates.length <= 100
- 1 <= candidates[i] <= 50
- 1 <= target <= 30
*/
func main() {
	fmt.Println("combinationSum2([]int{10, 1, 2, 7, 6, 1, 5}, 8) = ",
		combinationSum2([]int{10, 1, 2, 7, 6, 1, 5}, 8))
	fmt.Println("combinationSum2([]int{2, 5, 2, 1, 2}, 5) = ",
		combinationSum2([]int{2, 5, 2, 1, 2}, 5))
}

func combinationSum2(candidates []int, target int) [][]int {
	cnts := make(map[int]int)
	for _, num := range candidates {
		cnts[num]++
	}
	le := len(cnts)
	candidates = make([]int, 0, le)
	for c := range cnts {
		candidates = append(candidates, c)
	}
	sort.Ints(candidates)
	result := make([][]int, 0)
	stack := make([]int, 0)
	var dfs func(index int)
	dfs = func(index int) {
		if target <= 0 {
			result = append(result, append([]int{}, stack...))
			return
		}
		if index == le {
			return
		}
		candidate := candidates[index]
		if candidate > target {
			return
		}
		dfs(index + 1)
		for cnts[candidate] > 0 && target >= candidate {
			cnts[candidate]--
			stack = append(stack, candidate)
			target -= candidate
			dfs(index + 1)
			defer func() {
				cnts[candidate]++
				stack = stack[:len(stack)-1]
				target += candidate
			}()
		}
	}
	dfs(0)
	return result
}

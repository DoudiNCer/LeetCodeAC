package main

import (
	"fmt"
	"sort"
)

/*
一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。

给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。



示例 1：

输入：changed = [1,3,4,2,6,8]
输出：[1,3,4]
解释：一个可能的 original 数组为 [1,3,4] :
- 将 1 乘以 2 ，得到 1 * 2 = 2 。
- 将 3 乘以 2 ，得到 3 * 2 = 6 。
- 将 4 乘以 2 ，得到 4 * 2 = 8 。
其他可能的原数组方案为 [4,3,1] 或者 [3,1,4] 。
示例 2：

输入：changed = [6,3,0,1]
输出：[]
解释：changed 不是一个双倍数组。
示例 3：

输入：changed = [1]
输出：[]
解释：changed 不是一个双倍数组。


提示：

- 1 <= changed.length <= 10^5
- 0 <= changed[i] <= 10^5
*/

func main() {
	fmt.Println("findOriginalArray([]int{0, 0, 0, 0}) = ", findOriginalArray([]int{0, 0, 0, 0}))
}

func findOriginalArray(changed []int) []int {
	if len(changed)&1 == 1 {
		return []int{}
	}
	sort.Ints(changed)
	set := make(map[int]int)
	for _, c := range changed {
		if cnt, ok := set[c]; !ok {
			set[c] = 1
		} else {
			set[c] = cnt + 1
		}
	}
	fmt.Println("set = ", set)
	result := []int{}
	for len(changed) > 0 {
		x := changed[0]
		if _, ok := set[x]; ok {
			if _, ok := set[x*2]; ok {
				result = append(result, x)
				if set[x] == 1 {
					delete(set, x)
				} else {
					set[x] = set[x] - 1
				}
				if set[x*2] == 1 {
					delete(set, x*2)
				} else {
					set[x*2] = set[x*2] - 1
				}
			} else {
				return []int{}
			}
		}
		changed = changed[1:]
	}
	return result
}

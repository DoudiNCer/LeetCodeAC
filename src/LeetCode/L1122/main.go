package main

import (
	"fmt"
	"sort"
)

/*
给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。

对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

示例 1：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
示例  2:

输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
输出：[22,28,8,6,17,44]

提示：

- 1 <= arr1.length, arr2.length <= 1000
- 0 <= arr1[i], arr2[i] <= 1000
- arr2 中的元素 arr2[i]  各不相同
- arr2 中的每个元素 arr2[i] 都出现在 arr1 中
*/
func main() {
	fmt.Println("relativeSortArray([]int{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, []int{2,1,4,3,9,6}) = ", relativeSortArray([]int{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, []int{2, 1, 4, 3, 9, 6}))
	fmt.Println("relativeSortArray([]int{28, 6, 22, 8, 44, 17}, []int{22,28,8,6}) = ", relativeSortArray([]int{28, 6, 22, 8, 44, 17}, []int{22, 28, 8, 6}))
}

func relativeSortArray(arr1 []int, arr2 []int) []int {
	l2 := len(arr2)
	locations := make(map[int]int, l2)
	for i, a := range arr2 {
		locations[a] = i
	}
	sort.Slice(arr1, func(i, j int) bool {
		var xi, xj int
		if x, ok := locations[arr1[i]]; ok {
			xi = x
		} else {
			xi = l2 + arr1[i]
		}
		if y, ok := locations[arr1[j]]; ok {
			xj = y
		} else {
			xj = l2 + arr1[j]
		}
		return xi < xj
	})
	return arr1
}

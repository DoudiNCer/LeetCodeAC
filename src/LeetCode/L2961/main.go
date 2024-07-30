package main

import "fmt"

/*
给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target 。

如果满足以下公式，则下标 i 是 好下标：

0 <= i < variables.length
((ai^bi % 10)^ci) % mi == target
返回一个由 好下标 组成的数组，顺序不限 。

示例 1：

输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
输出：[0,2]
解释：对于 variables 数组中的每个下标 i ：
1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(23 % 10)3 % 10 = 2 。
2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(33 % 10)3 % 1 = 0 。
3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(61 % 10)1 % 4 = 2 。
因此，返回 [0,2] 作为答案。
示例 2：

输入：variables = [[39,3,1000,1000]], target = 17
输出：[]
解释：对于 variables 数组中的每个下标 i ：
1) 对于下标 0 ，variables[0] = [39,3,1000,1000] ，(393 % 10)1000 % 1000 = 1 。
因此，返回 [] 作为答案。

提示：

1 <= variables.length <= 100
variables[i] == [ai, bi, ci, mi]
1 <= ai, bi, ci, mi <= 103
0 <= target <= 103
*/
func main() {
	fmt.Println("getGoodIndices([][]int{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2) = ",
		getGoodIndices([][]int{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2))
}

func getGoodIndices(variables [][]int, target int) []int {
	var result []int
	for i, vs := range variables {
		ab := powWithMod(vs[0], vs[1], 10)
		if target == powWithMod(ab, vs[2], vs[3]) {
			result = append(result, i)
		}
	}
	return result
}

func powWithMod(a, n, m int) int {
	if n == 0 {
		return 1
	}
	a %= m
	if n == 1 {
		return a
	}
	r := 1
	if n%2 == 1 {
		r = a
	}
	n /= 2
	an := powWithMod(a, n, m)
	r *= an
	r %= m
	r *= an
	r %= m
	return r
}

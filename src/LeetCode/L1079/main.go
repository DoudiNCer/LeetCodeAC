package main

import (
	"fmt"
)

/*
*
你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。

注意：本题中，每个活字字模只能使用一次。

示例 1：

输入："AAB"
输出：8
解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
示例 2：

输入："AAABBC"
输出：188
示例 3：

输入："V"
输出：1

提示：

- 1 <= tiles.length <= 7
- tiles 由大写英文字母组成
*/
func main() {
	fmt.Println("numTilePossibilities(\"AAB\") = ", numTilePossibilities("AAB"))
}

func numTilePossibilities(tiles string) int {
	count := make([]int, 26)
	for _, t := range tiles {
		count[t-'A']++
	}
	var dfs func(int) int
	dfs = func(i int) int {
		if i == 0 {
			return 1
		}
		res := 1
		for c := 0; c < 26; c++ {
			if count[c] > 0 {
				count[c]--
				res += dfs(i - 1)
				count[c]++
			}
		}
		return res
	}
	return dfs(len(tiles)) - 1
}

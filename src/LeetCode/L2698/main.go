package main

import "fmt"

/*
*
给你一个正整数 n ，请你返回 n 的 惩罚数 。

n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：

1 <= i <= n
i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。

示例 1：

输入：n = 10
输出：182
解释：总共有 3 个整数 i 满足要求：
- 1 ，因为 1 * 1 = 1
- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
因此，10 的惩罚数为 1 + 81 + 100 = 182
示例 2：

输入：n = 37
输出：1478
解释：总共有 4 个整数 i 满足要求：
- 1 ，因为 1 * 1 = 1
- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
- 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478

提示：

- 1 <= n <= 1000
*/
func main() {
	fmt.Println("punishmentNumber(10) = ", punishmentNumber(10))
	fmt.Println("punishmentNumber(37) = ", punishmentNumber(37))
}

func punishmentNumber(n int) int {
	result := 0
	for i := 0; i <= n; i++ {
		if available(i) {
			result += i * i
		}
	}
	return result
}

var availableCache = map[int]bool{
	1:  true,
	9:  true,
	10: true,
}

func available(n int) bool {
	if result, ok := availableCache[n]; ok {
		return result
	}
	mm, nn, pp := 0, n*n, 1
	for nn > 0 {
		mms := spiltSum(mm)
		nns := spiltSum(nn)
		if len(mms) > len(nns) {
			mms, nns = nns, mms
		}
		for ls, _ := range mms {
			if _, ok := nns[n-ls]; ok {
				availableCache[n] = true
				return true
			}
		}
		mm += (nn % 10) * pp
		nn /= 10
		pp *= 10
	}
	availableCache[n] = false
	return false
}

var spiltSumCache = map[int]map[int]struct{}{
	0: {0: {}},
	1: {1: {}},
}

func spiltSum(n int) map[int]struct{} {
	if result, ok := spiltSumCache[n]; ok {
		return result
	}
	result := map[int]struct{}{
		n: {},
	}
	if n < 10 {
		spiltSumCache[n] = result
		return result
	}
	mm, nn, pp := 0, n, 1
	for nn > 9 {
		mm += (nn % 10) * pp
		nn /= 10
		pp *= 10
		mms, nns := spiltSum(mm), spiltSum(nn)
		for ms, _ := range mms {
			for ns, _ := range nns {
				result[ms+ns] = struct{}{}
			}
		}
	}
	result[mm+nn] = struct{}{}
	return result
}

package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个下标从 0 开始的二维整数数组 transactions，其中transactions[i] = [costi, cashbacki] 。

数组描述了若干笔交易。其中每笔交易必须以 某种顺序 恰好完成一次。在任意一个时刻，你有一定数目的钱 money ，为了完成交易 i ，money >= costi 这个条件必须为真。执行交易后，你的钱数 money 变成 money - costi + cashbacki 。

请你返回 任意一种 交易顺序下，你都能完成所有交易的最少钱数 money 是多少。

示例 1：

输入：transactions = [[2,1],[5,0],[4,2]]
输出：10
解释：
刚开始 money = 10 ，交易可以以任意顺序进行。
可以证明如果 money < 10 ，那么某些交易无法进行。
示例 2：

输入：transactions = [[3,0],[0,3]]
输出：3
解释：
- 如果交易执行的顺序是 [[3,0],[0,3]] ，完成所有交易需要的最少钱数是 3 。
- 如果交易执行的顺序是 [[0,3],[3,0]] ，完成所有交易需要的最少钱数是 0 。
所以，刚开始钱数为 3 ，任意顺序下交易都可以全部完成。

提示：

- 1 <= transactions.length <= 10^5
- transactions[i].length == 2
- 0 <= costi, cashbacki <= 10*9
*/
func main() {
	fmt.Println("minimumMoney([][]int{{2, 1}, {5, 0}, {4, 2}}) = ",
		minimumMoney([][]int{{2, 1}, {5, 0}, {4, 2}}))
	fmt.Println("minimumMoney([][]int{{3,9},{0,4},{7,10},{3,5},{0,9},{9,3},{7,4},{0,0},{3,3},{8,0}}) = ",
		minimumMoney([][]int{{3, 9}, {0, 4}, {7, 10}, {3, 5}, {0, 9}, {9, 3}, {7, 4}, {0, 0}, {3, 3}, {8, 0}}))
}

func minimumMoney(transactions [][]int) int64 {
	sort.Slice(transactions, func(i, j int) bool {
		ti, tj := transactions[i], transactions[j]
		di, dj := ti[1]-ti[0], tj[1]-tj[0]
		if di >= 0 && dj < 0 || di < 0 && dj >= 0 {
			return di < 0
		} else if di >= 0 && dj >= 0 {
			return ti[0] > tj[0]
		} else {
			return ti[1] < tj[1]
		}
	})
	result, money := int64(0), int64(0)
	for _, t := range transactions {
		if t0 := int64(t[0]); money < t0 {
			result += (t0 - money)
			money = t0
		}
		money += int64(t[1] - t[0])
	}
	return result
}

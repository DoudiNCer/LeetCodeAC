package main

import "fmt"

/*
*
给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: prices = [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
示例 2:

输入: prices = [1]
输出: 0

提示：

- 1 <= prices.length <= 5000
- 0 <= prices[i] <= 1000
*/
func main() {
	fmt.Println("maxProfit([]int{1, 2, 3, 0, 2}) = ", maxProfit([]int{1, 2, 3, 0, 2}))
}

func maxProfit(prices []int) int {
	dp := make([]int, 3)
	dp[0], dp[1], dp[2] = -prices[0], 0, 0
	for i := 1; i < len(prices); i++ {
		dp[0], dp[1], dp[2] = max(dp[0], dp[2]-prices[i]), max(dp[1], dp[0]+prices[i]), max(dp[2], dp[1])
	}
	return max(dp[1], dp[2])
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

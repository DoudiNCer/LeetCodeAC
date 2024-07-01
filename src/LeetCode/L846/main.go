package main

import (
	"fmt"
	"sort"
)

/*
Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。

给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌上的数值。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。

示例 1：

输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
输出：true
解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
示例 2：

输入：hand = [1,2,3,4,5], groupSize = 4
输出：false
解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。

提示：

- 1 <= hand.length <= 10^4
- 0 <= hand[i] <= 10^9
- 1 <= groupSize <= hand.length
*/
func main() {
	fmt.Println("isNStraightHand([]int{1,2,3,6,2,3,4,7,8}, 3) = ", isNStraightHand([]int{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3))
}

func isNStraightHand(hand []int, groupSize int) bool {
	if groupSize == 1 {
		return true
	}
	le := len(hand)
	if le%groupSize != 0 {
		return false
	}
	sort.Ints(hand)
	var cnts []int
	lp, np := -1, -1
	for len(hand) > 0 {
		lp = np
		np = hand[0]
		if np-lp > 1 {
			cnts = append(cnts, 0)
		}
		cnt := 0
		for len(hand) > 0 && hand[0] == np {
			cnt++
			hand = hand[1:]
		}
		cnts = append(cnts, cnt)
	}
	for len(cnts) > 0 {
		for len(cnts) > 0 && cnts[0] == 0 {
			cnts = cnts[1:]
		}
		if len(cnts) == 0 {
			return true
		}
		for i := 0; i < groupSize; i++ {
			if i+1 > len(cnts) {
				return false
			}
			if cnts[i] == 0 {
				return false
			}
			cnts[i]--
		}
	}
	return true
}

package main

import "fmt"

/*
*
给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。

数据范围：n≤50000，数组中元素的值 0≤val≤10000
要求：空间复杂度：O(1)，时间复杂度 O(n)
*/
func main() {
	fmt.Println("MoreThanHalfNum_Solution([]int{1,2,3,2,2,2,5,4,2}) = ", MoreThanHalfNum_Solution([]int{1, 2, 3, 2, 2, 2, 5, 4, 2}))
}

func MoreThanHalfNum_Solution(numbers []int) int {
	cnts := make(map[int]int)
	le := len(numbers) / 2
	for _, n := range numbers {
		cnts[n]++
		if cnts[n] > le {
			return n
		}
	}
	return -1
}

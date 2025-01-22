package main

import "fmt"

func main() {
	fmt.Println("permute([]int{1, 2, 3}) = ", permute([]int{1, 2, 3}))
	fmt.Println("permute([]int{1}) = ", permute([]int{1}))
}

func permute(nums []int) [][]int {
	n := len(nums)
	if n == 1 {
		return [][]int{nums}
	}
	result := make([][]int, 0)
	exist := make(map[int]bool, n)
	path := make([]int, 0, n)
	var bt func()
	bt = func() {
		le := len(path)
		if le == n {
			tmp := make([]int, n)
			copy(tmp, path)
			result = append(result, tmp)
			return
		}
		for _, num := range nums {
			if exist[num] {
				continue
			}
			exist[num] = true
			path = append(path, num)
			bt()
			path = path[:le]
			exist[num] = false
		}
	}
	bt()
	return result
}

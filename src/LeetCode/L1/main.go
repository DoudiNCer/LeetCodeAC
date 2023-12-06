package main

import "fmt"

func main() {
	n0 := []int{2, 7, 11, 15}
	t0 := 9
	fmt.Println(twoSum(n0, t0))
}

func twoSum(nums []int, target int) []int {
	nm := make(map[int]int, len(nums))
	for i, num := range nums {
		nm[num] = i
	}
	for i, num := range nums {
		x, ok := nm[target-num]
		if !ok {
			continue
		}
		if x != i {
			result := []int{x, i}
			return result
		}
	}
	return nil
}

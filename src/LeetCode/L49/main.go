package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println("groupAnagrams([]string{\"eat\", \"tea\", \"tan\", \"ate\", \"nat\", \"bat\"}) = ",
		groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}

func groupAnagrams(strs []string) [][]string {
	group := make(map[string][]string)
	for _, str := range strs {
		key := hash(str)
		group[key] = append(group[key], str)
	}
	result := make([][]string, 0, len(group))
	for _, strings := range group {
		result = append(result, strings)
	}
	return result
}

func hash(str string) string {
	chs := []rune(str)
	sort.Slice(chs, func(i, j int) bool {
		return chs[i] < chs[j]
	})
	return string(chs)
}

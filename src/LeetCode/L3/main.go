package main

import "fmt"

func main() {
	fmt.Println(lengthOfLongestSubstring("abcabcbb"))
}

func lengthOfLongestSubstring(s string) int {
	lenS := len(s)
	if lenS < 2 {
		return lenS
	}
	sm := make(map[byte]int)
	maxLen, left, right := 0, 0, 0
	for right < lenS {
		x, ok := sm[s[right]]
		if ok {
			left = max(left, x+1)
		}
		sm[s[right]] = right
		maxLen = max(maxLen, right-left+1)
		right++
	}
	return maxLen
}

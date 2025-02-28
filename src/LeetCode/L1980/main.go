package main

import "fmt"

/*
*
给你一个字符串数组 nums ，该数组由 n 个 互不相同 的二进制字符串组成，且每个字符串长度都是 n 。请你找出并返回一个长度为 n 且 没有出现 在 nums 中的二进制字符串。如果存在多种答案，只需返回 任意一个 即可。

示例 1：

输入：nums = ["01","10"]
输出："11"
解释："11" 没有出现在 nums 中。"00" 也是正确答案。
示例 2：

输入：nums = ["00","01"]
输出："11"
解释："11" 没有出现在 nums 中。"10" 也是正确答案。
示例 3：

输入：nums = ["111","011","001"]
输出："101"
解释："101" 没有出现在 nums 中。"000"、"010"、"100"、"110" 也是正确答案。

提示：

- n == nums.length
- 1 <= n <= 16
- nums[i].length == n
- nums[i] 为 '0' 或 '1'
- nums 中的所有字符串 互不相同
*/
func main() {
	fmt.Println("findDifferentBinaryString([]string{\"00\", \"01\"}) = ",
		findDifferentBinaryString([]string{"00", "01"}))
	fmt.Println("findDifferentBinaryString([]string{\"01\", \"10\"}) = ",
		findDifferentBinaryString([]string{"01", "10"}))
	fmt.Println("findDifferentBinaryString([]string{\"111\", \"011\", \"001\"}) = ",
		findDifferentBinaryString([]string{"111", "011", "001"}))
	fmt.Println("findDifferentBinaryString([]string{"+
		"\"0000000110\", \"0000000011\", \"0000000001\", \"0000000000\", \"0000001000\", "+
		"\"0000000100\", \"0000000101\", \"1111111111\", \"0000000111\", \"0000001001\"}) = ",
		findDifferentBinaryString([]string{
			"0000000110", "0000000011", "0000000001", "0000000000", "0000001000",
			"0000000100", "0000000101", "1111111111", "0000000111", "0000001001"}))
}

func findDifferentBinaryString(nums []string) string {
	n := len(nums)
	exist := make([]bool, n)
	for i := range nums {
		num := 0
		for str, i := nums[i], 0; i < n; i++ {
			num <<= 1
			num += int(str[i] - '0')
		}
		if num < n {
			exist[num] = true
		}
	}
	result := 0
	for result < n && exist[result] {
		result++
	}
	res := make([]byte, n)
	for i := n - 1; i >= 0; i-- {
		if result&1 > 0 {
			res[i] = '1'
		} else {
			res[i] = '0'
		}
		result >>= 1
	}
	return string(res)
}

package main

import (
	"fmt"
)

/*
*
字符串的 波动 定义为子字符串中出现次数 最多 的字符次数与出现次数 最少 的字符次数之差。

给你一个字符串 s ，它只包含小写英文字母。请你返回 s 里所有 子字符串的 最大波动 值。

子字符串 是一个字符串的一段连续字符序列。

示例 1：

输入：s = "aababbb"
输出：3
解释：
所有可能的波动值和它们对应的子字符串如以下所示：
- 波动值为 0 的子字符串："a" ，"aa" ，"ab" ，"abab" ，"aababb" ，"ba" ，"b" ，"bb" 和 "bbb" 。
- 波动值为 1 的子字符串："aab" ，"aba" ，"abb" ，"aabab" ，"ababb" ，"aababbb" 和 "bab" 。
- 波动值为 2 的子字符串："aaba" ，"ababbb" ，"abbb" 和 "babb" 。
- 波动值为 3 的子字符串 "babbb" 。
所以，最大可能波动值为 3 。
示例 2：

输入：s = "abcde"
输出：0
解释：
s 中没有字母出现超过 1 次，所以 s 中每个子字符串的波动值都是 0 。

提示：

- 1 <= s.length <= 10^4
- s  只包含小写英文字母。
*/
func main() {
	fmt.Println("largestVariance(\"aababbb\") = ", largestVariance("aababbb"))
	fmt.Println("largestVariance(\"abcde\") = ", largestVariance("abcde"))
	fmt.Println("largestVariance(\"lripaa\") = ", largestVariance("lripaa"))
	fmt.Println("largestVariance(\"isaxakdkzcwkjmpzcnum\") = ", largestVariance("isaxakdkzcwkjmpzcnum"))
}

func largestVariance(s string) int {
	var chs []rune
	{
		ws := make(map[rune]struct{})
		for _, v := range s {
			if _, ok := ws[v]; !ok {
				ws[v] = struct{}{}
			}
		}
		chs = make([]rune, 0, len(ws))
		for c := range ws {
			chs = append(chs, c)
		}
	}
	if len(chs) == 1 || len(chs) == len(s) {
		return 0
	}
	res := 0
	for i := 0; i < len(chs)-1; i++ {
		for j := i + 1; j < len(chs); j++ {
			cnts := make([]int, 0)
			cnt := 0
			for _, c := range s {
				if chs[i] != c && chs[j] != c {
					continue
				}
				if chs[i] == c {
					cnt++
				} else {
					cnt--
				}
				if res < abs(cnt) && abs(cnt) != len(cnts)+1 {
					res = abs(cnt)
				}
				for k, cnt0 := range cnts {
					ac := abs(cnt - cnt0)
					if ac == len(cnts)-k {
						continue
					}
					if ac > res {
						res = ac
					}
				}
				cnts = append(cnts, cnt)
			}
		}
	}
	return res
}

func abs(i int) int {
	if i < 0 {
		return -i
	}
	return i
}

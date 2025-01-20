package main

import "fmt"

/*
*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。

示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]

提示：

- 1 <= s.length <= 20
- s 仅由数字组成
*/
func main() {
	fmt.Println("restoreIpAddresses(\"25525511135\") = ", restoreIpAddresses("25525511135"))
	fmt.Println("restoreIpAddresses(\"0000\") = ", restoreIpAddresses("0000"))
	fmt.Println("restoreIpAddresses(\"101023\") = ", restoreIpAddresses("101023"))
}

func restoreIpAddresses(s string) []string {
	le := len(s)
	result := make([]string, 0)
	if le < 4 || le > 12 {
		return result
	}
	var rev func(int, int) ([]string, bool)
	rev = func(l, cnt int) (result []string, end bool) {
		if l == le && cnt == 0 {
			return []string{""}, true
		}
		if le-l < cnt || le-l > 3*cnt {
			return
		}
		cnt--
		if le-1-l >= cnt && le-1-l <= 3*cnt {
			st := s[l : l+1]
			subs, ed := rev(l+1, cnt)
			if !ed {
				st = st + "."
			}
			for _, sub := range subs {
				result = append(result, st+sub)
			}
		}
		if le-2-l >= cnt && le-2-l <= 3*cnt && s[l] != '0' {
			st := s[l : l+2]
			subs, ed := rev(l+2, cnt)
			if !ed {
				st = st + "."
			}
			for _, sub := range subs {
				result = append(result, st+sub)
			}
		}
		if le-3-l >= cnt && le-3-l <= 3*cnt && s[l] > '0' && s[l] <= '2' {
			num := int(s[l]-'0')*100 + int(s[l+1]-'0')*10 + int(s[l+2]-'0')
			if num > 255 {
				return
			}
			st := s[l : l+3]
			subs, ed := rev(l+3, cnt)
			if !ed {
				st = st + "."
			}
			for _, sub := range subs {
				result = append(result, st+sub)
			}
		}
		return
	}
	result, _ = rev(0, 4)
	return result
}

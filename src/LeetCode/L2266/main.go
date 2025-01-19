package main

import "fmt"

/*
*
Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。

为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。

比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。

比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。

由于答案可能很大，将它对 109 + 7 取余 后返回。

示例 1：

输入：pressedKeys = "22233"
输出：8
解释：
Alice 可能发出的文字信息包括：
"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
由于总共有 8 种可能的信息，所以我们返回 8 。
示例 2：

输入：pressedKeys = "222222222222222222222222222222222222"
输出：82876089
解释：
总共有 2082876103 种 Alice 可能发出的文字信息。
由于我们需要将答案对 109 + 7 取余，所以我们返回 2082876103 % (109 + 7) = 82876089 。

提示：

- 1 <= pressedKeys.length <= 10^5
- pressedKeys 只包含数字 '2' 到 '9' 。
*/
func main() {
	fmt.Println("countTexts(\"22233\") = ", countTexts("22233"))
}

const mod = int64(1000000007)

var dp3 = map[int]int64{
	0: 1,
	1: 1,
	2: 2,
	3: 4,
}

var dp4 = map[int]int64{
	0: 1,
	1: 1,
	2: 2,
	3: 4,
	4: 8,
}

func countTexts(pressedKeys string) int {
	result := int64(1)
	le, cnt := len(pressedKeys), 1
	for i := 1; i < le; i++ {
		if pressedKeys[i] == pressedKeys[i-1] {
			cnt++
			continue
		}
		result *= If(pressedKeys[i-1] == '9' || pressedKeys[i-1] == '7', dp4c(cnt), dp3c(cnt))
		result %= mod
		cnt = 1
	}
	result *= If(pressedKeys[le-1] == '9' || pressedKeys[le-1] == '7', dp4c(cnt), dp3c(cnt))
	return int(result % mod)
}

func dp3c(i int) int64 {
	if i < 0 {
		return 0
	}
	result, exist := dp3[i]
	if !exist {
		result = dp3c(i - 3)
		result += dp3c(i - 2)
		result += dp3c(i - 1)
		result %= mod
		dp3[i] = result
	}
	return result
}

func dp4c(i int) int64 {
	if i < 0 {
		return 0
	}
	result, exist := dp4[i]
	if !exist {
		result = dp4c(i - 4)
		result += dp4c(i - 3)
		result += dp4c(i - 2)
		result += dp4c(i - 1)
		result %= mod
		dp4[i] = result
	}
	return result
}

func If[T any](expression bool, trueVal, falseVal T) T {
	if expression {
		return trueVal
	} else {
		return falseVal
	}
}

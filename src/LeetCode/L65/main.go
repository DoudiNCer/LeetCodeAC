package main

import "fmt"

/*
*
给定一个字符串 s ，返回 s 是否是一个 有效数字。

例如，下面的都是有效数字："2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"，而接下来的不是："abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"。

一般的，一个 有效数字 可以用以下的规则之一定义：

一个 整数 后面跟着一个 可选指数。
一个 十进制数 后面跟着一个 可选指数。
一个 整数 定义为一个 可选符号 '-' 或 '+' 后面跟着 数字。

一个 十进制数 定义为一个 可选符号 '-' 或 '+' 后面跟着下述规则：

数字 后跟着一个 小数点 .。
数字 后跟着一个 小数点 . 再跟着 数位。
一个 小数点 . 后跟着 数位。
指数 定义为指数符号 'e' 或 'E'，后面跟着一个 整数。

数字 定义为一个或多个数位。

示例 1：

输入：s = "0"

输出：true

示例 2：

输入：s = "e"

输出：false

示例 3：

输入：s = "."

输出：false

提示：

- 1 <= s.length <= 20
- s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
*/
func main() {
	fmt.Println("isNumber(\"0\") = ", isNumber("0"))
	fmt.Println("isNumber(\"e\") = ", isNumber("e"))
	fmt.Println("isNumber(\".\") = ", isNumber("."))
	fmt.Println("isNumber(\".2\") = ", isNumber(".2"))
}

type State int

const (
	STATE_INITIAL State = iota
	STATE_INT_SIGN
	STATE_INTEGER
	STATE_POINT
	STATE_POINT_WITHOUT_INT
	STATE_FRACTION
	STATE_EXP
	STATE_EXP_SIGN
	STATE_EXP_NUMBER
)

type CharType int

const (
	CHAR_NUMBER CharType = iota
	CHAR_EXP
	CHAR_POINT
	CHAR_SIGN
	CHAR_ILLEGAL
)

func toCharType(ch byte) CharType {
	if ch >= '0' && ch <= '9' {
		return CHAR_NUMBER
	} else if ch == 'e' || ch == 'E' {
		return CHAR_EXP
	} else if ch == '.' {
		return CHAR_POINT
	} else if ch == '+' || ch == '-' {
		return CHAR_SIGN
	} else {
		return CHAR_ILLEGAL
	}
}

func isNumber(s string) bool {
	stateTransitionTable := map[State](map[CharType](State)){
		STATE_INITIAL: {
			CHAR_NUMBER: STATE_INTEGER,
			CHAR_SIGN:   STATE_INT_SIGN,
			CHAR_POINT:  STATE_POINT_WITHOUT_INT,
		},
		STATE_INT_SIGN: {
			CHAR_NUMBER: STATE_INTEGER,
			CHAR_POINT:  STATE_POINT_WITHOUT_INT,
		},
		STATE_POINT_WITHOUT_INT: {
			CHAR_NUMBER: STATE_FRACTION,
		},
		STATE_INTEGER: {
			CHAR_NUMBER: STATE_INTEGER,
			CHAR_EXP:    STATE_EXP,
			CHAR_POINT:  STATE_POINT,
		},
		STATE_POINT: {
			CHAR_NUMBER: STATE_FRACTION,
			CHAR_EXP:    STATE_EXP,
		},
		STATE_FRACTION: {
			CHAR_NUMBER: STATE_FRACTION,
			CHAR_EXP:    STATE_EXP,
		},
		STATE_EXP: {
			CHAR_NUMBER: STATE_EXP_NUMBER,
			CHAR_SIGN:   STATE_EXP_SIGN,
		},
		STATE_EXP_SIGN: {
			CHAR_NUMBER: STATE_EXP_NUMBER,
		},
		STATE_EXP_NUMBER: {
			CHAR_NUMBER: STATE_EXP_NUMBER,
		},
	}
	st := STATE_INITIAL
	for i := 0; i < len(s); i++ {
		ct := toCharType(s[i])
		var exists bool
		st, exists = stateTransitionTable[st][ct]
		if !exists {
			return false
		}
	}
	return st == STATE_INTEGER || st == STATE_FRACTION || st == STATE_EXP_NUMBER || st == STATE_POINT
}

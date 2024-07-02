package main

import "fmt"

func main() {
	fmt.Println("isValid(\"[{}]()\") = ", isValid("[{}]()"))
}

func isValid(s string) bool {
	le := len(s)
	if le&1 == 1 {
		return false
	}
	var stack []rune
	for _, c := range s {
		switch c {
		case '[':
			stack = append(stack, ']')
		case '{':
			stack = append(stack, '}')
		case '(':
			stack = append(stack, ')')
		default:
			p := len(stack)
			if p == 0 || stack[p-1] != c {
				return false
			}
			stack = stack[:p-1]
		}
	}
	return len(stack) == 0
}

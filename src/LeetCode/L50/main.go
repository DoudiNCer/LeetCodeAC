package main

import "fmt"

/*
实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
*/
func main() {
	fmt.Println("myPow(2.0, 10) = ", myPow(2.0, 10))
}

func myPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if x == 0 {
		return 0
	}
	if n%2 == 0 {
		t := myPow(x, n/2)
		return t * t
	}
	if n < 0 {
		return myPow(1/x, -n)
	}
	return myPow(x, n-1) * x
}

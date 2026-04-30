package main

import "fmt"

/*
*
在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。

示例 1：

输入：record = [9, 7, 5, 4, 6]
输出：8
解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。

提示：

- 0 <= record.length <= 50000
*/
func main() {
	fmt.Println("reversePairs([]int{9, 7, 5, 4, 6}) = ",
		reversePairs([]int{9, 7, 5, 4, 6}))
	fmt.Println("reversePairs([]int{1, 2, 1, 2, 1}) = ", reversePairs([]int{1, 2, 1, 2, 1}))
}

func reversePairs(record []int) int {
	n := len(record)
	{
		var ne, po bool
		for i := 1; i < n; i++ {
			if record[i] > record[i-1] {
				po = true
				if ne {
					break
				}
			} else if record[i] < record[i-1] {
				ne = true
				if po {
					break
				}
			}
		}
		if ne && !po {
			return n * (n - 1) / 2
		}
		if po && !ne {
			return 0
		}
	}
	var res int
	var mergeSort func(l, r int)
	mergeSort = func(l, r int) {
		if l >= r {
			return
		}
		if l+1 == r {
			if record[l] > record[r] {
				record[l], record[r] = record[r], record[l]
				res++
			}
			return
		}
		m := l + (r-l)/2
		mergeSort(l, m)
		mergeSort(m+1, r)
		tmp := make([]int, 0, r-l+1)
		for i, j := l, m+1; i <= m && j <= r; {
			if record[i] > record[j] {
				tmp = append(tmp, record[j])
				res += m + 1 - i
				j++
				if j > r {
					tmp = append(tmp, record[i:m+1]...)
				}
			} else {
				tmp = append(tmp, record[i])
				i++
				if i > m {
					tmp = append(tmp, record[j:r+1]...)
				}
			}
		}
		copy(record[l:r+1], tmp)
	}
	mergeSort(0, n-1)
	return res
}

package main

import "fmt"

/*
*
子字符串 是字符串中的一个连续（非空）的字符序列。

元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。

给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。

示例 1：

输入：word = "aeiouu"
输出：2
解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
- "aeiouu"
- "aeiouu"
示例 2：

输入：word = "unicornarihan"
输出：0
解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
示例 3：

输入：word = "cuaieuouac"
输出：7
解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
示例 4：

输入：word = "bbaeixoubb"
输出：0
解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。

提示：

- 1 <= word.length <= 100
- word 仅由小写英文字母组成
*/
func main() {
	fmt.Println("countVowelSubstrings(\"aeiouu\") = ", countVowelSubstrings("aeiouu"))
	fmt.Println("countVowelSubstrings(\"unicornarihan\") = ", countVowelSubstrings("unicornarihan"))
	fmt.Println("countVowelSubstrings(\"cuaieuouac\") = ", countVowelSubstrings("cuaieuouac"))
	fmt.Println("countVowelSubstrings(\"duuebuaeeeeeeuaoeiueaoui\") = ", countVowelSubstrings("duuebuaeeeeeeuaoeiueaoui"))
}

func countVowelSubstrings(word string) int {
	res := 0
	n := len(word)
	for l := 0; l < n-4; l++ {
		if hs(word[l]) == 0 {
			continue
		}
		cnt := make([]int, 6)
		for r := l; r < n; r++ {
			cnt[hs(word[r])]++
			if cnt[0] > 0 {
				break
			}
			if cnt[1] > 0 && cnt[2] > 0 && cnt[3] > 0 && cnt[4] > 0 && cnt[5] > 0 {
				res++
			}
		}
	}
	return res
}

func hs(c uint8) int {
	switch c {
	case 'a':
		return 1
	case 'e':
		return 2
	case 'i':
		return 3
	case 'o':
		return 4
	case 'u':
		return 5
	default:
		return 0
	}
}

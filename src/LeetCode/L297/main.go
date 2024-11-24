package main

import (
	"fmt"
	"strconv"
	"strings"
)

/*
*
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。

请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。

提示：

- 树中结点数在范围 [0, 10^4] 内
- -1000 <= Node.val <= 1000
*/
func main() {
	codec := Constructor()
	t0 := codec.serialize(nil)
	fmt.Println("codec.serialize(nil) = ", t0)
	fmt.Println("codec.deserialize(t0) = ", codec.deserialize(t0))
	t1 := codec.serialize(&TreeNode{Val: 1, Left: &TreeNode{Val: 2}})
	fmt.Println("codec.serialize(&TreeNode{Val: 1, Left: &TreeNode{Val: 2}}) = ",
		t1)
	fmt.Println("codec.deserialize(t1) = ", codec.deserialize(t1))
}

const baseStr = "-1"

type Codec struct {
}

func Constructor() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	if root == nil {
		return "(N)"
	}
	var result strings.Builder
	result.WriteRune('(')
	result.WriteString(strconv.Itoa(root.Val))
	result.WriteRune(',')
	result.WriteString(this.serialize(root.Left))
	result.WriteRune(',')
	result.WriteString(this.serialize(root.Right))
	result.WriteRune(')')
	return result.String()
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	data = data[1 : len(data)-1]
	if data[0] == 'N' {
		return nil
	}
	p, le := 0, len(data)
	for p < le {
		if data[p] == ',' {
			break
		}
		p++
	}
	if p == le {
		return &TreeNode{
			Val:   -1,
			Left:  nil,
			Right: nil,
		}
	}
	val, err := strconv.Atoi(data[:p])
	if err != nil {
		val = -1
	}
	result := &TreeNode{Val: val}
	sl, sr := this.cut(data[p+1:])
	result.Left = this.deserialize(sl)
	result.Right = this.deserialize(sr)
	return result
}

func (this *Codec) cut(str string) (s1, s2 string) {
	cnt, p, le := 0, 0, len(str)
	for ; p < le; p++ {
		if str[p] == '(' {
			cnt++
		} else if str[p] == ')' {
			cnt--
			if cnt == 0 {
				p++
				break
			}
		}
	}
	if p < le {
		return str[:p], str[p+1:]
	} else {
		return baseStr, baseStr
	}
}

/**
 * Your Codec object will be instantiated and called as such:
 * ser := Constructor();
 * deser := Constructor();
 * data := ser.serialize(root);
 * ans := deser.deserialize(data);
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

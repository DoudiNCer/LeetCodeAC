package main

import "fmt"

/*
Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

示例：

输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True

提示：

- 1 <= word.length, prefix.length <= 2000
- word 和 prefix 仅由小写英文字母组成
- insert、search 和 startsWith 调用次数 总计 不超过 3 * 10^4 次
*/
func main() {
	trie := Constructor()
	trie.Insert("apple")
	fmt.Println("trie = ", trie)
}

/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
type Trie struct {
	isEnd bool
	suns  map[uint8]*Trie
}

func Constructor() Trie {
	return Trie{
		isEnd: false,
		suns:  make(map[uint8]*Trie),
	}
}

func (this *Trie) Insert(word string) {
	if word == "" {
		this.isEnd = true
		return
	}
	p := this.suns[word[0]]
	if p == nil {
		c := Constructor()
		p = &c
	}
	p.Insert(word[1:])
	this.suns[word[0]] = p
}

func (this *Trie) Search(word string) bool {
	if word == "" {
		return this.isEnd
	}
	p := this.suns[word[0]]
	if p == nil {
		return false
	}
	return p.Search(word[1:])
}

func (this *Trie) StartsWith(prefix string) bool {
	if prefix == "" {
		return true
	}
	p := this.suns[prefix[0]]
	if p == nil {
		return false
	}
	return p.StartsWith(prefix[1:])
}

package main

import (
	"fmt"
	"sort"
)

/*
*
给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i 次会议的开始和结束天数（包含首尾）。

返回员工可工作且没有安排会议的天数。

注意：会议时间可能会有重叠。

示例 1：

输入：days = 10, meetings = [[5,7],[1,3],[9,10]]

输出：2

解释：

第 4 天和第 8 天没有安排会议。

示例 2：

输入：days = 5, meetings = [[2,4],[1,3]]

输出：1

解释：

第 5 天没有安排会议。

示例 3：

输入：days = 6, meetings = [[1,6]]

输出：0

解释：

所有工作日都安排了会议。

提示：

- 1 <= days <= 10^9
- 1 <= meetings.length <= 10^5
meetings[i].length == 2
1 <= meetings[i][0] <= meetings[i][1] <= days
*/
func main() {
	fmt.Println("countDays(10, [][]int{{5, 7}, {1, 3}, {9, 10}}) = ",
		countDays(10, [][]int{{5, 7}, {1, 3}, {9, 10}}))
}

func countDays(days int, meetings [][]int) int {
	mc := make(map[int]int)
	for i := range meetings {
		mc[meetings[i][0]]++
		mc[meetings[i][1]]--
	}
	mck := make([]int, 0, len(mc))
	for d := range mc {
		mck = append(mck, d)
	}
	sort.Ints(mck)
	res := 0
	cnt := mc[mck[0]]
	i := 1
	for ; i < len(mck) && mck[i] <= days; i++ {
		if cnt == 0 {
			res += mck[i] - mck[i-1] - 1
		}
		cnt += mc[mck[i]]
	}
	res += mck[0] - 1
	res += days - mck[i-1]
	return res
}

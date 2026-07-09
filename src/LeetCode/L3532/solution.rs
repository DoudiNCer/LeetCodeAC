use super::Solution;

/*
    给你一个整数 n，表示图中的节点数量，这些节点按从 0 到 n - 1 编号。

    同时给你一个长度为 n 的整数数组 nums，该数组按 非递减 顺序排序，以及一个整数 maxDiff。

    如果满足 |nums[i] - nums[j]| <= maxDiff（即 nums[i] 和 nums[j] 的 绝对差 至多为 maxDiff），则节点 i 和节点 j 之间存在一条 无向边 。

    此外，给你一个二维整数数组 queries。对于每个 queries[i] = [ui, vi]，需要判断节点 ui 和 vi 之间是否存在路径。

    返回一个布尔数组 answer，其中 answer[i] 等于 true 表示在第 i 个查询中节点 ui 和 vi 之间存在路径，否则为 false。

    提示：

    1 <= n == nums.length <= 10^5
    0 <= nums[i] <= 10^5
    nums 按 非递减 顺序排序。
    0 <= maxDiff <= 10^5
    1 <= queries.length <= 10^5
    queries[i] == [ui, vi]
    0 <= ui, vi < n
*/

impl Solution {
    pub fn path_existence_queries(
        n: i32,
        nums: Vec<i32>,
        max_diff: i32,
        queries: Vec<Vec<i32>>,
    ) -> Vec<bool> {
        let mut ufs: Vec<usize> = Vec::with_capacity(n as usize);
        ufs.push(0);
        for i in 1..n as usize {
            if nums[i - 1] + max_diff >= nums[i] {
                ufs.push(ufs[i - 1]);
            } else {
                ufs.push(i);
            }
        }
        let mut res = Vec::with_capacity(queries.len());
        for query in queries {
            res.push(ufs[query[0] as usize] == ufs[query[1] as usize])
        }
        res
    }
}

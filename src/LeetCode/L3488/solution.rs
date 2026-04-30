use super::Solution;

/*
    给你一个 环形 数组 nums 和一个数组 queries 。

    对于每个查询 i ，你需要找到以下内容：

    数组 nums 中下标 queries[i] 处的元素与 任意 其他下标 j（满足 nums[j] == nums[queries[i]]）之间的 最小 距离。如果不存在这样的下标 j，则该查询的结果为 -1 。
    返回一个数组 answer，其大小与 queries 相同，其中 answer[i] 表示查询i的结果。

    提示：

    1 <= queries.length <= nums.length <= 10^5
    1 <= nums[i] <= 10^6
    0 <= queries[i] < nums.length
*/

use std::collections::HashMap;
impl Solution {
    pub fn solve_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        let mut hs: HashMap<i32, Vec<usize>> = HashMap::new();
        let n = nums.len();
        for (i, num) in nums.iter().enumerate() {
            hs.entry(*num)
                .and_modify(|px| px.push(i))
                .or_insert(vec![i]);
        }
        let mut result = Vec::with_capacity(queries.len());
        for x in queries {
            let num = nums[x as usize];
            let ix: &Vec<usize> = &hs[&num];
            let ni = ix.len();
            if ni < 2 {
                result.push(-1);
                continue;
            }
            let xu = x as usize;
            let xi = ix.binary_search(&xu).unwrap();
            let l = ix[(ni + xi - 1) % ni];
            let r = ix[(xi + 1) % ni];
            let mut mi = (n + l - xu) % n;
            mi = mi.min((n + xu - l) % n);
            mi = mi.min((n + r - xu) % n);
            mi = mi.min((n + xu - r) % n);
            result.push(mi as i32);
        }
        result
    }
}

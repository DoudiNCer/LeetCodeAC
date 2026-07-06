use super::Solution;

/*
    给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。

    只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。

    在完成所有删除操作后，请你返回列表中剩余区间的数目。

    提示：

    1 <= intervals.length <= 1000
    0 <= intervals[i][0] < intervals[i][1] <= 10^5
    对于所有的 i != j：intervals[i] != intervals[j]
*/

use std::collections::HashSet;
impl Solution {
    pub fn remove_covered_intervals(intervals: Vec<Vec<i32>>) -> i32 {
        let mut intervals = intervals;
        intervals.sort_by(|a, b| a[0].cmp(&b[0]).then(b[1].cmp(&a[1])));
        let mut hs = HashSet::new();
        let n = intervals.len();
        for i in 0..n {
            for j in i + 1..n {
                if intervals[j][1] <= intervals[i][1] {
                    hs.insert(j);
                }
            }
        }
        (n - hs.len()) as i32
    }
}

use super::Solution;

/*
    给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。

    序号代表了一个元素有多大。序号编号的规则如下：

    序号从 1 开始编号。
    一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
    每个数字的序号都应该尽可能地小。

    提示：

    0 <= arr.length <= 10^5
    -10^9 <= arr[i] <= 10^9
*/

impl Solution {
    pub fn array_rank_transform(arr: Vec<i32>) -> Vec<i32> {
        let mut sorted_idx: Vec<usize> = (0..arr.len()).collect();
        sorted_idx.sort_by_key(|x| arr[*x]);
        let mut res = vec![1; arr.len()];
        for i in 1..arr.len() {
            if arr[sorted_idx[i - 1]] == arr[sorted_idx[i]] {
                res[sorted_idx[i]] = res[sorted_idx[i - 1]];
            } else {
                res[sorted_idx[i]] = res[sorted_idx[i - 1]] + 1;
            }
        }
        res
    }
}

use super::Solution;

/*
    给你一个下标从 0 开始的 正整数 数组 nums 和一个 正整数 limit 。

    在一次操作中，你可以选择任意两个下标 i 和 j，如果 满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 nums[j] 。

    返回执行任意次操作后能得到的 字典序最小的数组 。

    如果在数组 a 和数组 b 第一个不同的位置上，数组 a 中的对应元素比数组 b 中的对应元素的字典序更小，则认为数组 a 就比数组 b 字典序更小。例如，数组 [2,10,3] 比数组 [10,2,3] 字典序更小，下标 0 处是两个数组第一个不同的位置，且 2 < 10 。

    提示：

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
    1 <= limit <= 10^9
*/

impl Solution {
    pub fn lexicographically_smallest_array(nums: Vec<i32>, limit: i32) -> Vec<i32> {
        let n = nums.len();
        let mut num_pairs = Vec::with_capacity(n);
        for (i, num) in nums.iter().enumerate() {
            num_pairs.push((i, num));
        }
        num_pairs.sort_by_key(|k| *k.1);
        let mut ans = vec![0;n];
        let mut idxs = vec![];
        for i in 0..n {
            if i < n - 1 && num_pairs[i].1 + limit >= *num_pairs[i + 1].1 {
                idxs.push(num_pairs[i].0);
                continue;
            }
            idxs.push(num_pairs[i].0);
            idxs.sort();
            let offset = i + 1 - idxs.len();
            for (i, idx) in idxs.iter().enumerate() {
                ans[*idx] = *num_pairs[offset + i].1;
            }
            idxs.clear();
        }
        ans
    }
}

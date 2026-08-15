use super::Solution;

/*
    给你一个整数数组 nums 和一个整数 k 。

    一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。

    如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。

    请你返回 nums 中 最长好 子数组的长度。

    子数组 指的是一个数组中一段连续非空的元素序列。

    提示：

    1 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
    1 <= k <= nums.length
*/

use std::collections::HashMap;

impl Solution {
    pub fn max_subarray_length(nums: Vec<i32>, k: i32) -> i32 {
        let n = nums.len();
        let mut cntMap: HashMap<i32, i32> = HashMap::new();
        let mut res = 0;
        let (mut l, mut r) = (0, 0);
        while r < n {
            let cnt = cntMap.entry(nums[r]).and_modify(|c| *c += 1).or_insert(1);
            if *cnt > k {
                while l < r {
                    cntMap.entry(nums[l]).and_modify(|c| *c -= 1);
                    l += 1;
                    if cntMap[&nums[r]] <= k {
                        break;
                    }
                }
            }
            res = res.max((r - l + 1) as i32);
            r += 1;
        }
        res
    }
}

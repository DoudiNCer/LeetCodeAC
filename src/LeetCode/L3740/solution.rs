use std::collections::HashMap;
use super::Solution;

/*
  给你一个整数数组 nums。

  如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。

  有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。

  返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1。

  提示：

  1 <= n == nums.length <= 100
  1 <= nums[i] <= n
*/

impl Solution {
    pub fn minimum_distance(nums: Vec<i32>) -> i32 {
        let n = nums.len() as i32;
        if n < 3 {
            return -1;
        }
        let mut result = n;
        let mut hm: HashMap<i32, Vec<usize>> = HashMap::new();
        for (i, x) in nums.iter().enumerate() {
            let il = hm.entry(*x).or_insert(vec![]);
            if il.len() > 1 {
                let dist = (i - il[il.len() - 2]) as i32;
                if dist < result {
                    result = dist
                }
            }
            il.push(i);
        }

        if result == n {
            return -1
        }
        result << 1
    }
}
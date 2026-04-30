use super::Solution;

/*
    给你一个下标从 0 开始的整数数组 nums 。现有一个长度等于 nums.length 的数组 arr 。对于满足 nums[j] == nums[i] 且 j != i 的所有 j ，arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。

    返回数组 arr 。

    提示：

    1 <= nums.length <= 10^5
    0 <= nums[i] <= 10^9
*/

use std::collections::HashMap;
impl Solution {
    pub fn distance(nums: Vec<i32>) -> Vec<i64> {
        let mut result = Vec::with_capacity(nums.len());
        let mut idx: Vec<i32> = Vec::with_capacity(nums.len());
        let mut hm: HashMap<i32, Vec<i64>> = HashMap::new();
        for (i, num) in nums.iter().enumerate() {
            let arr = hm
                .entry(*num)
                .and_modify(|arr| {
                    let mut new = i as i64;
                    new += arr[arr.len() - 1];
                    arr.push(new);
                })
                .or_insert(vec![i as i64]);
            idx.push(arr.len() as i32 - 1);
        }
        for (i, num) in nums.iter().enumerate() {
            let arr = hm.get(num).unwrap();
            let cnt = arr.len() as i64 - 1;
            if cnt < 1 {
                result.push(0);
                continue;
            }
            let id = idx[i];
            let mut res = 0;
            if id > 0 {
                res += id as i64 * i as i64;
                res -= arr[id as usize - 1]
            }
            if id < cnt as i32 {
                res -= arr[id as usize];
                res += arr[cnt as usize];
                res -= i as i64 * (cnt - id as i64)
            }
            result.push(res);
        }
        result
    }
}

use super::Solution;

/*
    给你一个 正整数 数组 nums 。

    你需要从数组中选出一个满足下述条件的子集：

    你可以将选中的元素放置在一个下标从 0 开始的数组中，并使其遵循以下模式：[x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x]（注意，k 可以是任何 非负 的 2 的幂）。例如，[2, 4, 16, 4, 2] 和 [3, 9, 3] 都符合这一模式，而 [2, 4, 8, 4, 2] 则不符合。
    返回满足这些条件的子集中，元素数量的 最大值 。

    提示：

    2 <= nums.length <= 10^5
    1 <= nums[i] <= 10^9
*/

use std::collections::HashMap;
impl Solution {
    pub fn maximum_length(nums: Vec<i32>) -> i32 {
        let mut hm: HashMap<i32, i32> = HashMap::new();
        let mut keys = Vec::new();
        for num in nums {
            if let Some(cnt) = hm.get(&num) {
                hm.insert(num, cnt + 1);
            } else {
                hm.insert(num, 1);
                keys.push(num);
            }
        }
        let mut res = 0;
        keys.sort();
        for key in keys {
            let mut len = 0;
            let mut key = key;
            loop {
                if let Some(val) = hm.get(&key) {
                    if key == 1 {
                        len = *val;
                        break;
                    }
                    if *val == 1 {
                        len += 1;
                        break;
                    }
                    len += 2;
                    key *= key;
                } else {
                    break;
                }
            }
            res = res.max(1 + (((len - 1) >> 1) << 1));
        }
        res
    }
}

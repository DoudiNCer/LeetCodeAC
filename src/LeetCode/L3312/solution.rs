use super::Solution;

/*
    给你一个长度为 n 的整数数组 nums 和一个整数数组 queries 。

    gcdPairs 表示数组 nums 中所有满足 0 <= i < j < n 的数对 (nums[i], nums[j]) 的 最大公约数 升序 排列构成的数组。

    对于每个查询 queries[i] ，你需要找到 gcdPairs 中下标为 queries[i] 的元素。

    请你返回一个整数数组 answer ，其中 answer[i] 是 gcdPairs[queries[i]] 的值。

    gcd(a, b) 表示 a 和 b 的 最大公约数 。

    提示：

    2 <= n == nums.length <= 10^5
    1 <= nums[i] <= 5 * 10^4
    1 <= queries.length <= 10^5
    0 <= queries[i] < n * (n - 1) / 2
*/

impl Solution {
    pub fn gcd_values(nums: Vec<i32>, queries: Vec<i64>) -> Vec<i32> {
        let mut mx = nums[0];
        for num in nums.iter() {
            mx = mx.max(*num);
        }

        let mut cnts = vec![0i64; mx as usize + 1];
        for num in nums {
            cnts[num as usize] += 1;
        }

        for num in 1..=mx as usize {
            for mul in ((num << 1)..=mx as usize).step_by(num) {
                cnts[num] += cnts[mul];
            }
            cnts[num] = (cnts[num] * (cnts[num] - 1)) >> 1;
        }

        for num in (1..=mx as usize).rev() {
            for mul in ((num << 1)..=mx as usize).step_by(num) {
                cnts[num] -= cnts[mul];
            }
        }

        for num in 1..=(mx as usize) {
            cnts[num] += cnts[num - 1];
        }

        let mut res = Vec::with_capacity(queries.len());

        for query in queries {
            let (mut l, mut r) = (0, mx + 1);
            while l + 1 < r {
                let m = (l + r) >> 1;
                if cnts[m as usize] >= query + 1 {
                    r = m;
                } else {
                    l = m;
                }
            }
            res.push(r);
        }
        res
    }
}

use super::Solution;

/*
  给你一个长度为 n 的整数数组 nums 和一个大小为 q 的二维整数数组 queries，其中 queries[i] = [li, ri, ki, vi]。

  对于每个查询，按以下步骤执行操作：

  设定 idx = li。
  当 idx <= ri 时：
  更新：nums[idx] = (nums[idx] * vi) % (109 + 7)
  将 idx += ki。
  在处理完所有查询后，返回数组 nums 中所有元素的 按位异或 结果。

  提示：

  1 <= nums[i] <= 10^9
  1 <= q == queries.length <= 10^3
  1 <= n == nums.length <= 10^3
  queries[i] = [li, ri, ki, vi]
  0 <= li <= ri < n
  1 <= ki <= n
  1 <= vi <= 10^5
*/

impl Solution {
    pub fn xor_after_queries(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> i32 {
        const divisor: i64 = 1_000_000_007;
        let mut nums = nums;
        for query in queries {
            let mut l = query[0] as usize;
            let r = query[1] as usize;
            let k = query[2] as usize;
            let v = query[3] as i64;
            while l <= r {
                let mut num:i64 = nums[l] as i64;
                num *= v;
                num %= divisor;
                nums[l] = num as i32;
                l += k;
            }
        }
        let mut result = 0;
        for num in nums {
            result ^= num
        }
        result
    }
}
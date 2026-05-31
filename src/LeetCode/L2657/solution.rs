use super::Solution;

/*
    给你两个下标从 0 开始长度为 n 的整数排列 A 和 B 。

    A 和 B 的 前缀公共数组 定义为数组 C ，其中 C[i] 是数组 A 和 B 到下标为 i 之前公共元素的数目。

    请你返回 A 和 B 的 前缀公共数组 。

    如果一个长度为 n 的数组包含 1 到 n 的元素恰好一次，我们称这个数组是一个长度为 n 的 排列 。

    提示：

    1 <= A.length == B.length == n <= 50
    1 <= A[i], B[i] <= n
    题目保证 A 和 B 两个数组都是 n 个元素的排列。
*/

use std::collections::HashMap;
impl Solution {
    pub fn find_the_prefix_common_array(a: Vec<i32>, b: Vec<i32>) -> Vec<i32> {
        let n = a.len();
        let mut res = Vec::with_capacity(n);
        let mut hm = HashMap::new();
        for (i, ma) in a.iter().enumerate() {
            hm.insert(ma, true);
            let mut cnt = 0;
            for j in 0..=i {
                if let Some(_) = hm.get(&b[j]) {
                    cnt += 1;
                }
            }
            res.push(cnt)
        }
        res
    }
}

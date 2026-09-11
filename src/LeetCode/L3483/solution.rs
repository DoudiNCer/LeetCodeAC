use super::Solution;

/*
    给你一个数字数组 digits，你需要从中选择三个数字组成一个三位偶数，你的任务是求出 不同 三位偶数的数量。

    注意：每个数字在三位偶数中都只能使用 一次 ，并且 不能 有前导零。

    提示：

    3 <= digits.length <= 10
    0 <= digits[i] <= 9
*/

use std::collections::HashSet;

impl Solution {
    pub fn total_numbers(digits: Vec<i32>) -> i32 {
        let mut hs = HashSet::new();
        let n = digits.len();
        for i in 0..n {
            if digits[i] == 0 {
                continue;
            }
            for j in 0..n {
                if i == j {
                    continue;
                }
                for k in 0..n {
                    if i == k || j == k {
                        continue;
                    }
                    if digits[k] & 1 == 1 {
                        continue;
                    }
                    hs.insert(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }
        hs.len() as i32
    }
}

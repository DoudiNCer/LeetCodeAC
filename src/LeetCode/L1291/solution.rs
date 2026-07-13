use super::Solution;

/*
    我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。

    请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。

    提示：

    10 <= low <= high <= 10^9
*/

impl Solution {
    pub fn sequential_digits(low: i32, high: i32) -> Vec<i32> {
        let mut res = Vec::new();
        for i in 1..=9 {
            let mut num = 0;
            for j in i..=9 {
                num *= 10;
                num += j;
                if num < low {
                    continue;
                }
                if num > high {
                    break;
                }
                res.push(num);
            }
        }
        res.sort();
        res
    }
}

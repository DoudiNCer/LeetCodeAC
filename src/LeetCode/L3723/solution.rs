use super::Solution;

/*
    给你两个 正 整数 num 和 sum。

    如果一个正整数 n 满足以下两个条件，则称其为 好整数 ：

    n 的位数 恰好 为 num。
    n 的各位数字之和 恰好 为 sum。
    一个 好整数 n 的 分数 定义为 n 的各位数字的平方和。

    返回一个 字符串 ，表示能获得 最大分数 的 好整数 n。如果有多个可能的整数，返回 最大 的那个。如果不存在这样的整数，返回一个空字符串。

    提示:

    1 <= num <= 2 * 10^5
    1 <= sum <= 2 * 10^6
*/

impl Solution {
    pub fn max_sum_of_squares(num: i32, sum: i32) -> String {
        if num * 9 < sum {
            return String::new();
        }
        let mut res = String::new();
        let (mut num, mut sum) = (num, sum);
        while num > 0 {
            if sum > 9 {
                res.push(char::from(b'9'));
                sum -= 9;
            } else {
                res.push(char::from(b'0' + (sum as u8)));
                sum = 0
            }
            num -= 1;
        }
        res
    }
}

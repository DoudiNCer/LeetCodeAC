use super::Solution;

/*
    给你一个长度为 n 的二进制字符串 s，其中：

    '1' 表示一个 活跃 区段。
    '0' 表示一个 非活跃 区段。
    你可以执行 最多一次操作 来最大化 s 中的活跃区段数量。在一次操作中，你可以：

    将一个被 '0' 包围的连续 '1' 区块转换为全 '0'。
    然后，将一个被 '1' 包围的连续 '0' 区块转换为全 '1'。
    返回在执行最优操作后，s 中的 最大 活跃区段数。

    注意：处理时需要在 s 的两侧加上 '1' ，即 t = '1' + s + '1'。这些加上的 '1' 不会影响最终的计数。

    提示：

    1 <= n == s.length <= 10^5
    s[i] 仅包含 '0' 或 '1'
*/

impl Solution {
    pub fn max_active_sections_after_trade(s: String) -> i32 {
        let sb = s.as_bytes();
        let mut cnts = vec![0];
        let mut now = b'1' as u8;
        for (_, b) in sb.iter().enumerate() {
            if *b != now {
                cnts.push(1);
                now = *b;
            } else if let Some(cnt) = cnts.last_mut() {
                *cnt += 1;
            }
        }
        if now == b'0' as u8 {
            cnts.push(0);
        }
        let mut res_mx = 0;
        let mut res = cnts[0];
        for i in (1..cnts.len()).step_by(2) {
            if i > 2 {
                res_mx = res_mx.max(cnts[i] + cnts[i - 2]);
            }
            res += cnts[i + 1];
        }
        res + res_mx
    }
}

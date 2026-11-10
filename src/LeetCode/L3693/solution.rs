use super::Solution;

/*
    你正在爬一个有 n + 1 级台阶的楼梯，台阶编号从 0 到 n。

    你还得到了一个长度为 n 的 下标从 1 开始 的整数数组 costs，其中 costs[i] 是第 i 级台阶的成本。

    从第 i 级台阶，你 只能 跳到第 i + 1、i + 2 或 i + 3 级台阶。从第 i 级台阶跳到第 j 级台阶的成本定义为： costs[j] + (j - i)2

    你从第 0 级台阶开始，初始 cost = 0。

    返回到达第 n 级台阶所需的 最小 总成本。

    提示:

    1 <= n == costs.length <= 10^5
    1 <= costs[i] <= 10^4
*/
impl Solution {
    pub fn climb_stairs(n: i32, costs: Vec<i32>) -> i32 {
        let n = n as usize;
        let mut dp = vec![0; n + 1];
        for i in 0..n {
            dp[i + 1] = dp[i] + 1;
            for d in 1..=2 {
                if i < d {
                    break;
                }
                dp[i + 1] = dp[i + 1].min(dp[i - d] + ((d + 1) * (d + 1)) as i32)
            }
            dp[i + 1] += costs[i];
        }
        dp[n]
    }
}

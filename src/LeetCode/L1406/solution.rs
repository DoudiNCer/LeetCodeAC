use super::Solution;

/*
    Alice 和 Bob 继续他们的石子游戏。几堆石子 排成一行 ，每堆石子都对应一个得分，由数组 stoneValue 给出。

    Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头都被拿走。

    每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。

    比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。

    假设 Alice 和 Bob 都采取 最优策略 。

    如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，分数相同返回 "Tie" 。
    提示：

    1 <= stoneValue.length <= 5 * 10^4
    -1000 <= stoneValue[i] <= 1000
*/

impl Solution {
    pub fn stone_game_iii(stone_value: Vec<i32>) -> String {
        let n = stone_value.len();
        let mut dp = vec![(0, 0); n + 1];
        for i in (0..n).rev() {
            let mut take = stone_value[i];
            dp[i] = (dp[i + 1].1 + take, dp[i + 1].0 - take);
            for d in 1..3 {
                if i + d >= n {
                    break;
                }
                take += stone_value[i + d];
                dp[i].0 = dp[i].0.max(dp[i + d + 1].1 + take);
                dp[i].1 = dp[i].1.min(dp[i + d + 1].0 - take)
            }
        }
        if dp[0].0 > 0 {
            String::from("Alice")
        } else if dp[0].0 < 0 {
            String::from("Bob")
        } else {
            String::from("Tie")
        }
    }
}

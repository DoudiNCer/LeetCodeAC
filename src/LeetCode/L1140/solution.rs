use super::Solution;

/*
    Alice 和 Bob 继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。

    Alice 和 Bob 轮流进行，Alice 先开始。最初，M = 1。

    在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。

    游戏一直持续到所有石子都被拿走。

    假设 Alice 和 Bob 都发挥出最佳水平，返回 Alice 可以得到的最大数量的石头。

    提示：

    1 <= piles.length <= 100
    1 <= piles[i] <= 10^4
*/

use std::collections::HashMap;

impl Solution {
    pub fn stone_game_ii(piles: Vec<i32>) -> i32 {
        let n = piles.len();
        let mut prefix_sum = vec![0; n + 1];
        for i in (0..n) {
            prefix_sum[i + 1] = prefix_sum[i] + piles[i];
        }
        let mut dp: HashMap<(usize, usize), i32> = HashMap::new();
        (prefix_sum[n] + Self::dfs(0, 1, n, &mut prefix_sum, &mut dp)) >> 1
    }
    fn dfs(
        i: usize,
        m: usize,
        n: usize,
        prefix_sum: &mut Vec<i32>,
        dp: &mut HashMap<(usize, usize), i32>,
    ) -> i32 {
        if i >= n {
            return 0;
        }
        if let Some(r) = dp.get(&(i, m)) {
            return *r;
        }
        let mut res = i32::MIN;
        for d in 1..((m << 1) + 1) {
            if i + d > n {
                break;
            }
            res = res.max(
                prefix_sum[i + d] - prefix_sum[i] - Self::dfs(i + d, m.max(d), n, prefix_sum, dp),
            )
        }
        dp.insert((i, m), res);
        res
    }
}

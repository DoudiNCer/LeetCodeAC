use super::Solution;

/*
    几块石子 排成一行 ，每块石子都有一个关联值，关联值为整数，由数组 stoneValue 给出。

    游戏中的每一轮：Alice 会将这行石子分成两个 非空行（即，左侧行和右侧行）；Bob 负责计算每一行的值，即此行中所有石子的值的总和。Bob 会丢弃值最大的行，Alice 的得分为剩下那行的值（每轮累加）。如果两行的值相等，Bob 让 Alice 决定丢弃哪一行。下一轮从剩下的那一行开始。

    只 剩下一块石子 时，游戏结束。Alice 的分数最初为 0 。

    返回 Alice 能够获得的最大分数 。

    提示：

    1 <= stoneValue.length <= 500
    1 <= stoneValue[i] <= 10^6
*/

use std::cmp::max;
use std::collections::HashMap;

impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        let n = stone_value.len();
        let mut presum = vec![0; n + 1];
        for (i, val) in stone_value.iter().enumerate() {
            presum[i + 1] = presum[i] + *val;
        }
        let mut dp: HashMap<(usize, usize), i32> = HashMap::new();

        Self::dfs(0, n - 1, &mut presum, &mut dp)
    }

    fn dfs(
        l: usize,
        r: usize,
        presum: &mut Vec<i32>,
        dp: &mut HashMap<(usize, usize), i32>,
    ) -> i32 {
        if l == r {
            return 0;
        }
        if let Some(res) = dp.get(&(l, r)) {
            return *res;
        }

        let mut res = 0;
        for k in l..r {
            let (sl, sr) = (presum[k + 1] - presum[l], presum[r + 1] - presum[k + 1]);
            if sl == sr {
                // Try the best way
                res =
                    res.max(sl + max(Self::dfs(l, k, presum, dp), Self::dfs(k + 1, r, presum, dp)));
            } else if sl > sr {
                // remove stones[l..=k]
                res = res.max(sr + Self::dfs(k + 1, r, presum, dp));
            } else {
                // remove stones[k+1..=r]
                res = res.max(sl + Self::dfs(l, k, presum, dp));
            }
        }
        dp.insert((l, r), res);
        res
    }
}

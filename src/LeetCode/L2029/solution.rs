use super::Solution;

/*
    Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，其中 stones[i] 是第 i 个石子的价值。

    Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones 中移除任一石子。

    - 如果玩家移除石子后，导致 所有已移除石子 的价值 总和 可以被 3 整除，那么该玩家就 输掉游戏 。
    - 如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。

    假设两位玩家均采用 最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。

    提示：

    1 <= stones.length <= 10^5
    1 <= stones[i] <= 10^4
*/

impl Solution {
    pub fn stone_game_ix(stones: Vec<i32>) -> bool {
        let mut cnt = vec![0i32; 3];
        for stone in stones {
            cnt[(stone % 3) as usize] += 1;
        }

        // Alice will lose when first move
        if cnt[1] == 0 && cnt[2] == 0 {
            return false;
        }

        // All cnt[0] will be offset
        if cnt[0] & 1 == 0 {
            // Only 1 or only 2, Alice will lose when third move
            // Otherwise, Alice can choise the least one to win.(1-2 can be offset)
            return cnt[1] != 0 && cnt[2] != 0;
        }
        
        // cnt[0] can change the relationship, So 3 cnt[1] or cnt[2] can let Bob lose
        let diff = cnt[1] - cnt[2];
        diff.abs() > 2
    }
}

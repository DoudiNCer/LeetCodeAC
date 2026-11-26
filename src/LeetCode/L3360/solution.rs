use super::Solution;

/*
    Alice 和 Bob 在玩一个游戏，他们俩轮流从一堆石头中移除石头，Alice 先进行操作。
    
    Alice 在第一次操作中移除 恰好 10 个石头。
    接下来的每次操作中，每位玩家移除的石头数 恰好 为另一位玩家上一次操作的石头数减 1 。
    第一位没法进行操作的玩家输掉这个游戏。
    
    给你一个正整数 n 表示一开始石头的数目，如果 Alice 赢下这个游戏，请你返回 true ，否则返回 false 。
    
    提示：
    
    1 <= n <= 50
*/

impl Solution {
    pub fn can_alice_win(n: i32) -> bool {
        let mut n = n;
        for d in 0..10 {
            let num = 10 - d;
            if n < num {
                return num & 1 == 1
            }
            n -= num;
        }
        false
    }
}
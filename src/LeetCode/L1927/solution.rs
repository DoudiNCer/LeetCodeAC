use super::Solution;

/*
    Alice 和 Bob 玩一个游戏，两人轮流行动，Alice 先手 。

    给你一个 偶数长度 的字符串 num ，每一个字符为数字字符或者 '?' 。每一次操作中，如果 num 中至少有一个 '?' ，那么玩家可以执行以下操作：

    选择一个下标 i 满足 num[i] == '?' 。
    将 num[i] 用 '0' 到 '9' 之间的一个数字字符替代。
    当 num 中没有 '?' 时，游戏结束。

    Bob 获胜的条件是 num 中前一半数字的和 等于 后一半数字的和。Alice 获胜的条件是前一半的和与后一半的和 不相等 。

    比方说，游戏结束时 num = "243801" ，那么 Bob 获胜，因为 2+4+3 = 8+0+1 。如果游戏结束时 num = "243803" ，那么 Alice 获胜，因为 2+4+3 != 8+0+3 。
    在 Alice 和 Bob 都采取 最优 策略的前提下，如果 Alice 获胜，请返回 true ，如果 Bob 获胜，请返回 false 。

    提示：

    2 <= num.length <= 10^5
    num.length 是 偶数 。
    num 只包含数字字符和 '?' 。
*/

impl Solution {
    pub fn sum_game(num: String) -> bool {
        let num = num.as_bytes();
        let n = num.len();
        let mut cnt = 0;
        let mut sm = 0;
        let (mut l, mut r) = (0, n - 1);
        while l < r {
            match num[l] {
                b'?' => {
                    cnt += 1;
                }
                (b) => {
                    sm += (b - b'0') as i32;
                }
            }
            match num[r] {
                b'?' => {
                    cnt -= 1;
                }
                (b) => {
                    sm -= (b - b'0') as i32;
                }
            }
            l += 1;
            r -= 1;
        }
        
        if cnt == 0 || sm == 0 {
            // no action or Alice win
            return !(cnt == 0 && sm == 0)
        }
        if cnt > 0 && sm > 0 || cnt < 0 && sm < 0 {
            // Never balance
            return true
        }
        if cnt < 0 {
            cnt = -cnt;
        } else { 
            sm = -sm;
        }
        if cnt & 1 == 1 {
            // Alice do the last time
            return true
        }
        
        // Bob can fix, so consider edge status
        if (cnt >> 1) * 9 < sm {
            // Alice do all 0 
            return true
        }
        if (cnt >> 1) * 9 > sm {
            // Alice do all 9
            return true;
        }
        return false
    }
}

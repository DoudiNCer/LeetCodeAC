use super::Solution;

/*
    给你一个长度为 n 的字符串 moves ，该字符串仅由字符 'L'、'R' 和 '_' 组成。字符串表示你在一条原点为 0 的数轴上的若干次移动。

    你的初始位置就在原点（0），第 i 次移动过程中，你可以根据对应字符选择移动方向：

    如果 moves[i] = 'L' 或 moves[i] = '_' ，可以选择向左移动一个单位距离
    如果 moves[i] = 'R' 或 moves[i] = '_' ，可以选择向右移动一个单位距离
    移动 n 次之后，请你找出可以到达的距离原点 最远 的点，并返回 从原点到这一点的距离 。

    提示：

    1 <= moves.length == n <= 50
    moves 仅由字符 'L'、'R' 和 '_' 组成
*/

impl Solution {
    pub fn furthest_distance_from_origin(moves: String) -> i32 {
        let mut diff = 0i32;
        let mut cnt = 0i32;
        let mut bb = moves.bytes();
        loop {
            match bb.next() {
                Some(b'L') => diff += 1,
                Some(b'R') => diff -= 1,
                Some(_) => cnt += 1,
                None => break,
            }
        }
        diff.abs() + cnt
    }
}

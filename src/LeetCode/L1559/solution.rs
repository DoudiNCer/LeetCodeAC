use super::Solution;

/*
    给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。

    一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。

    同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。

    如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。

    提示：

    m == grid.length
    n == grid[i].length
    1 <= m <= 500
    1 <= n <= 500
    grid 只包含小写英文字母。
*/

use std::collections::HashMap;

impl Solution {
    fn dfs(
        grid: &Vec<Vec<char>>,
        found: &mut HashMap<(i32, i32), i32>,
        p: (i32, i32),
        depth: i32,
    ) -> bool {
        let (m, n) = (grid.len(), grid[0].len());
        found.insert(p, depth);
        let (px, py) = p;
        let ch = grid[px as usize][py as usize];
        for (dx, dy) in [(-1, 0), (1, 0), (0, -1), (0, 1)] {
            let (qx, qy) = (px + dx, py + dy);
            if qx < 0 || qx >= m as i32 || qy < 0 || qy >= n as i32 {
                continue;
            }
            if grid[qx as usize][qy as usize] != ch {
                continue;
            }
            let q = (qx, qy);
            if let Some(d) = found.get(&q) {
                if *d > 0 {
                    if depth - *d >= 3 {
                        return true;
                    }
                    continue;
                }
                continue;
            }
            let res = Self::dfs(grid, found, q, depth + 1);
            if res {
                return true;
            }
        }
        found.insert(p, 0);
        false
    }
    pub fn contains_cycle(grid: Vec<Vec<char>>) -> bool {
        let (m, n) = (grid.len(), grid[0].len());
        let mut found: HashMap<(i32, i32), i32> = HashMap::with_capacity(m * n);
        for x in (0..m) {
            for y in (0..n) {
                let p = (x as i32, y as i32);
                let res = Self::dfs(&grid, &mut found, p, 1);
                if res {
                    return true;
                }
            }
        }
        false
    }
}

use super::Solution;

/*
    给你一个 m x n 的二进制矩形 grid 和一个整数 health 表示你的健康值。

    你开始于矩形的左上角 (0, 0) ，你的目标是矩形的右下角 (m - 1, n - 1) 。

    你可以在矩形中往上下左右相邻格子移动，但前提是你的健康值始终是 正数 。

    对于格子 (i, j) ，如果 grid[i][j] = 1 ，那么这个格子视为 不安全 的，会使你的健康值减少 1 。

    如果你可以到达最终的格子，请你返回 true ，否则返回 false 。

    注意 ，当你在最终格子的时候，你的健康值也必须为 正数 。

    提示：

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    2 <= m * n
    1 <= health <= m + n
    grid[i][j] 要么是 0 ，要么是 1 。
*/

use std::collections::HashSet;
impl Solution {
    pub fn find_safe_walk(grid: Vec<Vec<i32>>, health: i32) -> bool {
        let (m, n) = (grid.len(), grid[0].len());
        if health >= (m + n) as i32 {
            return true;
        }
        let mut dangerous = vec![vec![(m + n + 1) as i32; n]; m];
        dangerous[0][0] = grid[0][0];
        let mut hs = HashSet::new();
        hs.insert((0i32, 0i32));
        while hs.len() > 0 {
            let mut nxhs = HashSet::new();
            for x in hs.iter() {
                let (i, j) = *x;
                for (ii, jj) in [(i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)] {
                    if ii < 0 || jj < 0 || ii >= m as i32 || jj >= n as i32 {
                        continue;
                    }
                    if hs.contains(&(ii, jj)) {
                        continue;
                    }
                    let ohs = dangerous[ii as usize][jj as usize];
                    dangerous[ii as usize][jj as usize] =
                        ohs.min(dangerous[i as usize][j as usize] + grid[ii as usize][jj as usize]);
                    if dangerous[ii as usize][jj as usize] <= health
                        && dangerous[ii as usize][jj as usize] < ohs
                    {
                        nxhs.insert((ii, jj));
                    }
                }
            }
            hs = nxhs;
        }
        dangerous[m - 1][n - 1] < health
    }
}

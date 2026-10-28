use super::Solution;

/*
    给你一个大小为 m * n 的二维整数数组 grid。

    你从 左上角 的单元格 (0, 0) 出发，想要到达 右下角 的单元格 (m - 1, n - 1)。

    在每一步中，你 可以 向右或向下 移动。

    路径的 代价 定义为该路径上所有单元格（包括 起点和终点）的值的 按位异或。

    返回从 (0, 0) 到 (m - 1, n - 1) 的所有有效路径中 最小 的可能异或值。

    提示：

    1 <= m == grid.length <= 1000
    1 <= n == grid[i].length <= 1000
    m * n <= 1000
    0 <= grid[i][j] <= 1023
*/

impl Solution {
    pub fn min_cost(grid: Vec<Vec<i32>>) -> i32 {
        let (m, n) = (grid.len(), grid[0].len());
        let mut dp = vec![vec![vec![false; 1024]; n]; m];
        dp[0][0][grid[0][0] as usize] = true;
        {
            let mut xor = grid[0][0];
            for i in 1..m {
                xor ^= grid[i][0];
                dp[i][0][xor as usize] = true;
            }
        }
        {
            let mut xor = grid[0][0];
            for j in 1..n {
                xor ^= grid[0][j];
                dp[0][j][xor as usize] = true;
            }
        }
        for i in 1..m {
            for j in 1..n {
                for x in 0..1024 {
                    let xor = x ^ grid[i][j];
                    dp[i][j][xor as usize] |= dp[i][j - 1][x as usize];
                    dp[i][j][xor as usize] |= dp[i - 1][j][x as usize];
                }
            }
        }
        for x in 0..1024 {
            if dp[m - 1][n - 1][x] {
                return x as i32;
            }
        }
        0
    }
}

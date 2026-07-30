use super::Solution;

/*
    给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。

    每次「迁移」操作将会引发下述活动：

    位于 grid[i][j]（j < n - 1）的元素将会移动到 grid[i][j + 1]。
    位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
    位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
    请你返回 k 次迁移操作后最终得到的 二维网格。

    提示：

    m == grid.length
    n == grid[i].length
    1 <= m <= 50
    1 <= n <= 50
    -1000 <= grid[i][j] <= 1000
    0 <= k <= 100
*/

impl Solution {
    pub fn shift_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        let (m, n) = (grid.len(), grid[0].len());
        let CNT = (m * n);
        let k = k as usize % CNT;
        if k == 0 {
            return grid;
        }

        let location = |x: usize, y: usize| -> (usize, usize) {
            let mut tg = x * n + y;
            tg += k;
            tg %= CNT;
            (tg / n, tg % n)
        };
        let mut result = vec![vec![0; n]; m];
        for i in 0..m {
            for j in 0..n {
                let (x, y) = location(i, j);
                result[x][y] = grid[i][j];
            }
        }
        result
    }
}

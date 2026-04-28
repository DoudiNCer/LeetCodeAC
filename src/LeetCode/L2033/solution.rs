use super::Solution;

/*
    给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。

    单值网格 是全部元素都相等的网格。

    返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。

    提示：

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 10^5
    1 <= m * n <= 10^5
    1 <= x, grid[i][j] <= 10^4
*/

impl Solution {
    pub fn min_operations(grid: Vec<Vec<i32>>, x: i32) -> i32 {
        let (m, n) = (grid.len(), grid[0].len());
        let mut diffs: Vec<i32> = Vec::with_capacity(m * n);
        let rem = grid[0][0] % x;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] % x != rem {
                    return -1;
                }
                diffs.push(grid[i][j] / x);
            }
        }
        diffs.sort();
        let target = diffs[diffs.len() >> 1];
        let mut result = 0;
        for diff in diffs {
            result += (diff - target).abs()
        }
        result
    }
}

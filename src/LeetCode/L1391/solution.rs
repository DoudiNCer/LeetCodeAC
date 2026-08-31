use super::Solution;

/*
    给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：

    1 表示连接左单元格和右单元格的街道。
    2 表示连接上单元格和下单元格的街道。
    3 表示连接左单元格和下单元格的街道。
    4 表示连接右单元格和下单元格的街道。
    5 表示连接左单元格和上单元格的街道。
    6 表示连接右单元格和上单元格的街道。
    
    你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。

    注意：你 不能 变更街道。

    如果网格中存在有效的路径，则返回 true，否则返回 false 。

    提示：

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    1 <= grid[i][j] <= 6
*/

const CASES: [[(i32, i32); 2]; 6] = [
    [(-1, 0), (1, 0)],
    [(0, -1), (0, 1)],
    [(-1, 0), (0, 1)],
    [(1, 0), (0, 1)],
    [(-1, 0), (0, -1)],
    [(1, 0), (0, -1)],
];
impl Solution {
    fn dfs(grid: &Vec<Vec<i32>>, moved: &mut Vec<bool>, p: (usize, usize)) -> bool {
        let (n, m) = (grid.len(), grid[0].len());
        let (px, py) = p;
        if px == (m - 1) && py == (n - 1) {
            return true;
        }
        moved[m * py + px] = true;
        for (dx, dy) in CASES[grid[py][px] as usize - 1] {
            let (qx, qy) = (px as i32 + dx, py as i32 + dy);
            if qx < 0 || qy < 0 || qx >= m as i32 || qy >= n as i32 {
                continue;
            }
            if moved[m * qy as usize + qx as usize] {
                continue;
            }
            for (ndx, ndy) in CASES[grid[qy as usize][qx as usize] as usize - 1] {
                if ndx != -dx || ndy != -dy {
                    continue;
                }
                let res = Self::dfs(grid, moved, (qx as usize, qy as usize));
                if res {
                    return true;
                }
            }
        }
        moved[m * py + px] = false;
        false
    }
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        let (n, m) = (grid.len(), grid[0].len());
        let mut moved: Vec<bool> = vec![false; m * n];
        Self::dfs(&grid, &mut moved, (0, 0))
    }
}

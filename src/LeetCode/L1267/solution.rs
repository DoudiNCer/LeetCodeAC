use super::Solution;

/*
    这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
    
    如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
    
    请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
    
    提示：
    
    m == grid.length
    n == grid[i].length
    1 <= m <= 250
    1 <= n <= 250
    grid[i][j] == 0 or 1
*/

impl Solution {
    pub fn count_servers(grid: Vec<Vec<i32>>) -> i32 {
        let (m, n) = (grid.len(), grid[0].len());
        let (mut mc, mut nc) = (vec![0;m], vec![0;n]);
        let mut cnt = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 0 {
                    continue;
                }
                mc[i] += 1;
                nc[j] += 1;
                cnt += 1;
            }
        }
        let mut single_cnt = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 0 {
                    continue;
                }
                if mc[i] < 2 && nc[j] < 2 {
                    single_cnt += 1;
                }
            }
        }
        cnt - single_cnt
    }
}

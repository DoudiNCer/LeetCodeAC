use super::Solution;

/*
    给你一个大小为 m x n 的整数矩阵 grid​​​ ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。

    矩阵由若干层组成，如下图所示，每种颜色代表一层：

    矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：

    返回执行 k 次循环轮转操作后的矩阵。


    提示：

    m == grid.length
    n == grid[i].length
    2 <= m, n <= 50
    m 和 n 都是 偶数
    1 <= grid[i][j] <= 5000
    1 <= k <= 109
*/

impl Solution {
    pub fn rotate_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        let (m, n) = (grid.len(), grid[0].len());
        let loc = |d, i| -> (usize, usize) {
            let (mm, nn) = (m - (d << 1), n - (d << 1));
            if i < nn {
                return (d, d + i);
            } else if i < (mm + nn - 1usize) {
                return (d + i - nn + 1, d + nn - 1);
            } else if i < (mm + (nn << 1) - 2usize) {
                return (d + mm - 1usize, d + (mm + (nn << 1) - 3usize) - i);
            } else {
                return (d + ((mm + nn - 2usize) << 1) - i, d);
            }
        };
        let mut grid = grid;
        for d in 0..((m.min(n)) >> 1) {
            let cnt = (m + n - 2 - (d << 2)) << 1;
            let kk = k as usize % cnt;
            if kk == 0 {
                continue;
            }
            let mut tmp: Vec<i32> = Vec::with_capacity(cnt);
            for i in 0..cnt {
                let (x, y) = loc(d, i);
                tmp.push(grid[x][y])
            }
            for (i, num) in tmp.iter().enumerate() {
                let (x, y) = loc(d, (cnt + i - kk) % cnt);
                grid[x][y] = *num;
            }
        }
        grid
    }
}

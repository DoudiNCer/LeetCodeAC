use super::Solution;

/*
    二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。

    请返回 封闭岛屿 的数目。

    提示：

    1 <= grid.length, grid[0].length <= 100
    0 <= grid[i][j] <=1
*/

use std::collections::HashSet;

struct UnionFindSet {
    root_arr: Vec<i32>,
}

impl UnionFindSet {
    fn new(n: i32) -> UnionFindSet {
        UnionFindSet {
            root_arr: (0..n).collect(),
        }
    }

    fn find(&mut self, num: i32) -> i32 {
        let p = self.root_arr[num as usize];
        if p == num {
            return p;
        }
        let pp = self.find(p);
        if p != pp {
            self.root_arr[num as usize] = pp
        }
        pp
    }

    fn union(&mut self, a: i32, b: i32) {
        let (pa, pb) = (self.find(a), self.find(b));
        if pa != pb {
            self.root_arr[pa as usize] = pb
        }
    }
}

impl Solution {
    pub fn closed_island(grid: Vec<Vec<i32>>) -> i32 {
        let (m, n) = (grid.len(), grid[0].len());
        let mut ufs = UnionFindSet::new((m * n) as i32);
        for i in 1..m {
            for j in 1..n {
                if grid[i][j] == 1 {
                    continue;
                }
                if grid[i][j - 1] == 0 {
                    ufs.union((i * n + j) as i32, (i * n + j - 1) as i32);
                }
                if grid[i - 1][j] == 0 {
                    ufs.union((i * n + j) as i32, ((i - 1) * n + j) as i32);
                }
            }
        }
        let mut ok_set: HashSet<i32> = HashSet::new();
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    continue;
                }
                ok_set.insert(ufs.find((i * n + j) as i32));
            }
        }
        for i in 0..m {
            for j in vec![0, n - 1] {
                ok_set.remove(&ufs.find((i * n + j) as i32));
            }
        }
        for j in 0..n {
            for i in vec![0, m - 1] {
                ok_set.remove(&ufs.find((i * n + j) as i32));
            }
        }
        ok_set.len() as i32
    }
}

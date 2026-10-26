use super::Solution;

/*
    给你一个 m x n 的矩阵 grid 和一个正整数 k。一个 岛屿 是由 正 整数（表示陆地）组成的，并且陆地间 四周 连通（水平或垂直）。

    一个岛屿的总价值是该岛屿中所有单元格的值之和。

    返回总价值可以被 k 整除 的岛屿数量。

    提示:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 1000
    1 <= m * n <= 10^5
    0 <= grid[i][j] <= 10^6
    1 <= k < = 10^6
*/

use std::collections::HashMap;

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
    pub fn count_islands(grid: Vec<Vec<i32>>, k: i32) -> i32 {
        let (m, n) = (grid.len(), grid[0].len());
        let mut ufs = UnionFindSet::new((m * n) as i32);
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 0 {
                    continue;
                }
                if i + 1 < m {
                    if grid[i + 1][j] > 0 {
                        ufs.union((i * n + j) as i32, ((i + 1) * n + j) as i32);
                    }
                }
                if j + 1 < n {
                    if grid[i][j + 1] > 0 {
                        ufs.union((i * n + j) as i32, (i * n + j + 1) as i32);
                    }
                }
            }
        }
        let mut score_map: HashMap<i32, i32> = HashMap::new();
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 0 {
                    continue;
                }
                let para = ufs.find((i * n + j) as i32);
                score_map
                    .entry(para)
                    .and_modify(|s| *s = (*s + grid[i][j]) % k)
                    .or_insert(grid[i][j] % k);
            }
        }
        let mut res = 0;
        for v in score_map.values() {
            if *v % k == 0 {
                res += 1;
            }
        }
        res
    }
}

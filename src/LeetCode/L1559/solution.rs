use super::Solution;
use std::process::id;

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
    pub fn contains_cycle(grid: Vec<Vec<char>>) -> bool {
        let (m, n) = (grid.len(), grid[0].len());
        let idx = |x, y| (x + m * y) as i32;
        let mut ufs = UnionFindSet::new((m * n) as i32);
        for x in 0..m {
            for y in 0..n {
                let id = idx(x, y);
                let r = ufs.find(id);
                for (dx, dy) in [(0, 1), (1, 0)] {
                    let (px, py) = (x + dx, y + dy);
                    if px >= m || py >= n {
                        continue;
                    }
                    if grid[x][y] != grid[px][py] {
                        continue;
                    }
                    let idp = idx(px, py);
                    let rd = ufs.find(idp);
                    if rd == r {
                        return true;
                    }
                    ufs.union(id, idp);
                }
            }
        }
        false
    }
}

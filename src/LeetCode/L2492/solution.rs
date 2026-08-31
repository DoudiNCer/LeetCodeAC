use super::Solution;

/*
    给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。给你一个二维数组 roads ，其中 roads[i] = [ai, bi, distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，道路距离为 distancei 。城市构成的图不一定是连通的。

    两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。

    返回城市 1 和城市 n 之间的所有路径的 最小 分数。

    注意：

    - 一条路径指的是两个城市之间的道路序列。
    - 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。
    - 测试数据保证城市 1 和城市n 之间 至少 有一条路径。

    提示：

    - 2 <= n <= 10^5
    - 1 <= roads.length <= 10^5
    - roads[i].length == 3
    - 1 <= ai, bi <= n
    - ai != bi
    - 1 <= distancei <= 10^4
    - 不会有重复的边。
    - 城市 1 和城市 n 之间至少有一条路径。
*/

struct UnionFindSet {
    root_str: Vec<i32>,
}

impl UnionFindSet {
    fn new(n: i32) -> UnionFindSet {
        UnionFindSet {
            root_str: (0..n).collect(),
        }
    }

    fn find(&mut self, num: i32) -> i32 {
        if num >= self.root_str.len() as i32 {
            return num;
        }
        let p = self.root_str[num as usize];
        if p == num {
            return p;
        }
        let pp = self.find(p);
        self.root_str[num as usize] = pp;
        pp
    }

    fn union(&mut self, a: i32, b: i32) {
        if a >= self.root_str.len() as i32 || b >= self.root_str.len() as i32 {
            return;
        }
        let (pa, pb) = (self.find(a), self.find(b));
        if pa != pb {
            self.root_str[pa as usize] = pb;
        }
    }

    fn is_union(&mut self, a: i32, b: i32) -> bool {
        self.find(a) == self.find(b)
    }
}

impl Solution {
    pub fn min_score(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        let mut res = 0;
        let mut ufs = UnionFindSet::new(n + 1);
        for road in roads.iter() {
            let (a, b, distance) = (road[0], road[1], road[2]);
            res = res.max(distance);
            ufs.union(a, b);
        }
        for road in roads.iter() {
            let (a, b, distance) = (road[0], road[1], road[2]);
            if !ufs.is_union(a, n) {
                continue;
            }
            res = res.min(distance);
        }
        res
    }
}

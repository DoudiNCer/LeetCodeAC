use super::Solution;

/*
    给你一个整数 n 。现有一个包含 n 个顶点的 无向 图，顶点按从 0 到 n - 1 编号。给你一个二维整数数组 edges 其中 edges[i] = [ai, bi] 表示顶点 ai 和 bi 之间存在一条 无向 边。

    返回图中 完全连通分量 的数量。

    如果在子图中任意两个顶点之间都存在路径，并且子图中没有任何一个顶点与子图外部的顶点共享边，则称其为 连通分量 。

    如果连通分量中每对节点之间都存在一条边，则称其为 完全连通分量 。

    提示：

    1 <= n <= 50
    0 <= edges.length <= n * (n - 1) / 2
    edges[i].length == 2
    0 <= ai, bi <= n - 1
    ai != bi
    不存在重复的边
*/

use std::collections::{HashMap, HashSet};
struct UnionFindSet {
    root_vec: Vec<i32>,
}

impl UnionFindSet {
    fn new(n: i32) -> UnionFindSet {
        UnionFindSet {
            root_vec: (0..n).collect(),
        }
    }

    fn find(&mut self, q: i32) -> i32 {
        if q < 0 || q >= self.root_vec.len() as i32 {
            return q;
        }

        let p = self.root_vec[q as usize];
        if p == q {
            return p;
        }

        let pp = self.find(p);
        self.root_vec[q as usize] = pp;
        pp
    }

    fn union(&mut self, a: i32, b: i32) {
        let (pa, pb) = (self.find(a), self.find(b));
        if pa > pb {
            self.root_vec[pa as usize] = pb;
        } else if pa < pb {
            self.root_vec[pb as usize] = pa;
        }
    }
}

impl Solution {
    pub fn count_complete_components(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        let mut ufs = UnionFindSet::new(n);
        for edge in edges.iter() {
            ufs.union(edge[0], edge[1]);
        }
        let mut edge_cnt = vec![0; n as usize];
        let mut node_set: HashMap<i32, HashSet<i32>> = HashMap::new();
        for edge in edges.iter() {
            let root = ufs.find(edge[0]);
            edge_cnt[root as usize] += 1;
        }
        for node in 0..n {
            node_set
                .entry(ufs.find(node))
                .and_modify(|s| {
                    s.insert(node);
                })
                .or_insert(HashSet::from([node]));
        }
        let mut res = 0;
        for (root, nodes) in node_set.iter() {
            let node_cnt = nodes.len();
            if (node_cnt * (node_cnt - 1)) >> 1 == edge_cnt[*root as usize] {
                res += 1;
            }
        }
        res
    }
}

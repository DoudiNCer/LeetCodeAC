use super::Solution;

/*
    给你一个包含 n 个节点（编号从 0 到 n - 1）的有向无环图。图由长度为 m 的二维数组 edges 表示，其中 edges[i] = [ui, vi, costi] 表示从节点 ui 到节点 vi 的单向通信，恢复成本为 costi。

    一些节点可能处于离线状态。给定一个布尔数组 online，其中 online[i] = true 表示节点 i 在线。节点 0 和 n - 1 始终在线。

    从 0 到 n - 1 的路径如果满足以下条件，那么它是 有效 的：

    路径上的所有中间节点都在线。
    路径上所有边的总恢复成本不超过 k。
    对于每条有效路径，其 分数 定义为该路径上的最小边成本。

    返回所有有效路径中的 最大 路径分数（即最大 最小 边成本）。如果没有有效路径，则返回 -1。

    提示:

    n == online.length
    2 <= n <= 5 * 10^4
    0 <= m == edges.length <= min(10*5, n * (n - 1) / 2)
    edges[i] = [ui, vi, costi]
    0 <= ui, vi < n
    ui != vi
    0 <= costi <= 10^9
    0 <= k <= 5 * 10^13
    online[i] 是 true 或 false，且 online[0] 和 online[n - 1] 均为 true。
    给定的图是一个有向无环图。
*/

use std::collections::HashMap;
impl Solution {
    pub fn find_max_path_score(edges: Vec<Vec<i32>>, online: Vec<bool>, k: i64) -> i32 {
        if edges.len() == 0 {
            return -1
        }
        
        let n = online.len();

        // turn edges into map
        let mut dag: HashMap<i32, Vec<(i32, i32)>> = HashMap::with_capacity(n);
        let mut mx_c = edges[0][2];
        for edge in edges {
            let (u, v, cost) = (edge[0], edge[1], edge[2]);
            if !online[u as usize] || !online[v as usize] {
                continue;
            }
            mx_c = mx_c.max(cost);
            dag.entry(u)
                .and_modify(|e| {
                    e.push((v, cost));
                    // e.sort_by(|a, b| a.1.cmp(&b.1));
                })
                .or_insert(vec![(v, cost)]);
        }
        // Binary search
        let (mut l, mut r) = (-1, mx_c + 1);
        while l + 1 < r {
            let m = (l + r) >> 1;
            let mut hm: HashMap<i32, i64> = HashMap::new();
            hm.insert(0, 0);
            let mut ok = false;
            while !hm.is_empty() {
                let mut nxhm: HashMap<i32, i64> = HashMap::new();
                for (u, c) in hm {
                    if ok {
                        break;
                    }
                    if let Some(vcs) = dag.get(&u) {
                        for (v, cst) in vcs {
                            if *cst < m {
                                continue;
                            }
                            let ncs = c + (*cst as i64);
                            if ncs > k {
                                continue;
                            }
                            if *v == (n - 1) as i32 {
                                ok = true;
                                break;
                            }
                            nxhm.entry(*v)
                                .and_modify(|e| {
                                    *e = (*e).min(ncs);
                                })
                                .or_insert(ncs);
                        }
                    } else {
                        continue;
                    }
                }
                hm = nxhm;
            }
            if ok {
                l = m;
            } else {
                r = m;
            }
        }
        l
    }
}

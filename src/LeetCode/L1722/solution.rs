use super::Solution;

/*
    给你两个整数数组 source 和 target ，长度都是 n 。还有一个数组 allowedSwaps ，其中每个 allowedSwaps[i] = [ai, bi] 表示你可以交换数组 source 中下标为 ai 和 bi（下标从 0 开始）的两个元素。注意，你可以按 任意 顺序 多次 交换一对特定下标指向的元素。

    相同长度的两个数组 source 和 target 间的 汉明距离 是元素不同的下标数量。形式上，其值等于满足 source[i] != target[i] （下标从 0 开始）的下标 i（0 <= i <= n-1）的数量。

    在对数组 source 执行 任意 数量的交换操作后，返回 source 和 target 间的 最小汉明距离 。

    提示:

    n == source.length == target.length
    1 <= n <= 10^5
    1 <= source[i], target[i] <= 10^5
    0 <= allowedSwaps.length <= 10^5
    allowedSwaps[i].length == 2
    0 <= ai, bi <= n - 1
    ai != bi
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
    pub fn minimum_hamming_distance(
        source: Vec<i32>,
        target: Vec<i32>,
        allowed_swaps: Vec<Vec<i32>>,
    ) -> i32 {
        let n = source.len();
        let mut set = UnionFindSet::new(n as i32);
        for x in allowed_swaps {
            let (p, q) = (x[0], x[1]);
            set.union(p, q);
        }
        let mut hm: HashMap<i32, HashMap<i32, i32>> = HashMap::new();
        for (i, a) in source.iter().enumerate() {
            let b = target[i];
            if *a == b {
                continue;
            }
            let p = set.find(i as i32);
            let mut m = hm.entry(p).or_insert(HashMap::new());
            m.entry(*a)
                .and_modify(|c| {
                    *c += 1;
                })
                .or_insert(1);
            m.entry(b)
                .and_modify(|c| {
                    *c -= 1;
                })
                .or_insert(-1);
        }
        let mut res = 0;
        for (_, m) in hm {
            for (_, c) in m {
                res += c.abs()
            }
        }
        res >> 1
    }
}

use super::Solution;

/*
    你正在维护一个项目，该项目有 n 个方法，编号从 0 到 n - 1。
    
    给你两个整数 n 和 k，以及一个二维整数数组 invocations，其中 invocations[i] = [ai, bi] 表示方法 ai 调用了方法 bi。
    
    已知如果方法 k 存在一个已知的 bug。那么方法 k 以及它直接或间接调用的任何方法都被视为 可疑方法 ，我们需要从项目中移除这些方法。
    
    只有当一组方法没有被这组之外的任何方法调用时，这组方法才能被移除。
    
    返回一个数组，包含移除所有 可疑方法 后剩下的所有方法。你可以以任意顺序返回答案。如果无法移除 所有 可疑方法，则 不 移除任何方法。
    
    提示:
    
    1 <= n <= 10^5
    0 <= k <= n - 1
    0 <= invocations.length <= 2 * 10^5
    invocations[i] == [ai, bi]
    0 <= ai, bi <= n - 1
    ai != bi
    invocations[i] != invocations[j]
*/

use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn remaining_methods(n: i32, k: i32, invocations: Vec<Vec<i32>>) -> Vec<i32> {
        let mut invocationMap:HashMap<i32, HashSet<i32>> = HashMap::new();
        for inv in invocations.iter() {
            invocationMap.entry(inv[0]).and_modify(|fs| {
                fs.insert(inv[1]);
            }).or_insert(HashSet::from([inv[1]]));
        }
        let mut killed = HashSet::from([k]);
        let mut targets = HashSet::from([k]);
        while !targets.is_empty() {
            let mut nts = HashSet::new();
            for target in targets.iter() {
                if let Some(nt) = invocationMap.get(target) {
                    for ntt in nt.iter() {
                        if killed.contains(ntt) {
                            continue;
                        }
                        nts.insert(*ntt);
                        killed.insert(*ntt);
                    }
                }
            }
            targets = nts;
        }
        for inv in invocations {
            if killed.contains(&inv[1]) && !killed.contains(&inv[0]) {
                killed = HashSet::new();
                break
            }
        }
        let mut res = Vec::with_capacity(n as usize - killed.len());
        for node in 0..n {
            if killed.contains(&node) {
                continue
            }
            res.push(node);
        }
        res
    }
}
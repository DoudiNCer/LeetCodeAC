use super::Solution;

/*
    给你五个整数 cost1, cost2, costBoth, need1 和 need2。

    有三种类型的物品可以购买：

    类型 1 的物品花费 cost1，并仅满足类型 1 的需求 1 个单位。
    类型 2 的物品花费 cost2，并仅满足类型 2 的需求 1 个单位。
    类型 3 的物品花费 costBoth，同时满足类型 1 和类型 2 的需求各 1 个单位。
    你需要购买足够的物品，使得：

    满足类型 1 的总需求 至少 为 need1。
    满足类型 2 的总需求 至少 为 need2。
    返回满足这些需求的 最小 可能总花费。

    提示：

    1 <= cost1, cost2, costBoth <= 10^6
    0 <= need1, need2 <= 10^9
*/

impl Solution {
    pub fn minimum_cost(cost1: i32, cost2: i32, cost_both: i32, need1: i32, need2: i32) -> i64 {
        let cost_both = cost_both.min(cost1 + cost2) as i64;
        let cost1 = cost_both.min(cost1 as i64);
        let cost2 = cost_both.min(cost2 as i64);
        (need1.min(need2) as i64) * cost_both
            + cost1 * (need1 - need1.min(need2)) as i64
            + cost2 * (need2 - need1.min(need2)) as i64
    }
}

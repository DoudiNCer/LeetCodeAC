use super::Solution;

/*
    在一座城市里，你需要建 n 栋新的建筑。这些新的建筑会从 1 到 n 编号排成一列。

    这座城市对这些新建筑有一些规定：

    每栋建筑的高度必须是一个非负整数。
    第一栋建筑的高度 必须 是 0 。
    任意两栋相邻建筑的高度差 不能超过  1 。
    除此以外，某些建筑还有额外的最高高度限制。这些限制会以二维整数数组 restrictions 的形式给出，其中 restrictions[i] = [idi, maxHeighti] ，表示建筑 idi 的高度 不能超过 maxHeighti 。

    题目保证每栋建筑在 restrictions 中 至多出现一次 ，同时建筑 1 不会 出现在 restrictions 中。

    请你返回 最高 建筑能达到的 最高高度 。

    提示：

    2 <= n <= 10^9
    0 <= restrictions.length <= min(n - 1, 10^5)
    2 <= idi <= n
    idi 是 唯一的 。
    0 <= maxHeighti <= 10^9
*/

impl Solution {
    pub fn max_building(n: i32, restrictions: Vec<Vec<i32>>) -> i32 {
        let mut restrictions = restrictions;
        restrictions.push(vec![1, 0]);
        restrictions.sort_by_key(|k| k[0]);
        let mut m = restrictions.iter().len();
        if restrictions[m - 1][0] != n {
            m += 1;
            restrictions.push(vec![n, n - 1])
        }
        let m = m;
        for i in 1..m {
            let dx = restrictions[i][0] - restrictions[i - 1][0];
            let dy = restrictions[i][1] - restrictions[i - 1][1];
            if dy > 0 {
                if dy > dx {
                    restrictions[i] = vec![restrictions[i][0], restrictions[i - 1][1] + dx]
                }
            } else {
                if -dy > dx {
                    restrictions[i - 1] = vec![restrictions[i - 1][0], restrictions[i][1] + dx]
                }
            }
        }
        for i in (1..m).rev() {
            let dx = restrictions[i][0] - restrictions[i - 1][0];
            let dy = restrictions[i][1] - restrictions[i - 1][1];
            if dy > 0 {
                if dy > dx {
                    restrictions[i] = vec![restrictions[i][0], restrictions[i - 1][1] + dx]
                }
            } else {
                if -dy > dx {
                    restrictions[i - 1] = vec![restrictions[i - 1][0], restrictions[i][1] + dx]
                }
            }
        }
        let mut res = 0;
        for i in 1..m {
            let dx = restrictions[i][0] - restrictions[i - 1][0];
            let dy = restrictions[i][1] - restrictions[i - 1][1];
            if dy > 0 {
                res = res.max(restrictions[i][1] + ((dx - dy) >> 1))
            } else {
                res = res.max(restrictions[i - 1][1] + ((dx + dy) >> 1))
            }
        }
        res
    }
}

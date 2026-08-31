use super::Solution;

/*
    如上图所示，电影院的观影厅中有 n 行座位，行编号从 1 到 n ，且每一行内总共有 10 个座位，列编号从 1 到 10 。

    给定一个二维数组 reservedSeats ，其中 reservedSeats[i] = [rowi, seati] 表示第 rowi 行的座位 seati 已经被预定。

    四人小组必须被安排在同一排的四个座位上。该小组可以坐在以下座位块之一：

    座位 2, 3, 4, 5
    座位 4, 5, 6, 7
    座位 6, 7, 8, 9
    只有当该块中的所有座位都 没有 被预订时，才能使用该块。每个座位 最多 只能分配给一个小组。

    返回一个整数，表示可以分配的 最大 四人小组数量。

    提示：

    1 <= n <= 10^9
    1 <= reservedSeats.length <= min(10 * n, 10^4)
    reservedSeats[i] == [rowi, seati]
    1 <= rowi <= n
    1 <= seati <= 10
    所有 reservedSeats[i] 都是互不相同的。
*/

use std::collections::HashMap;

const LOC_0: i32 = (1 << 1) + (1 << 2) + (1 << 3) + (1 << 4);
const LOC_1: i32 = (1 << 3) + (1 << 4) + (1 << 5) + (1 << 6);
const LOC_2: i32 = (1 << 5) + (1 << 6) + (1 << 7) + (1 << 8);

impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        let mut hm: HashMap<i32, i32> = HashMap::new();
        for set in reserved_seats {
            hm.entry(set[0])
                .and_modify(|x| *x = *x | 1 << (set[1] - 1))
                .or_insert(1 << (set[1] - 1));
        }
        let mut res = n << 1;
        for val in hm.values() {
            let ok_0 = (*val) & LOC_0;
            let ok_1 = (*val) & LOC_1;
            let ok_2 = (*val) & LOC_2;
            if (ok_0 == 0) && (ok_2 == 0) {
                continue;
            }
            if (ok_0 == 0) || (ok_1 == 0) || (ok_2 == 0) {
                res -= 1;
                continue;
            }
            res -= 2;
        }
        res
    }
}

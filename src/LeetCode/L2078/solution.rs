use super::Solution;

/*
    街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。

    返回 两栋 颜色 不同 房子之间的 最大 距离。

    第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。

    提示:

    n == colors.length
    2 <= n <= 100
    0 <= colors[i] <= 100
    生成的测试数据满足 至少 存在 2 栋颜色不同的房子
*/

impl Solution {
    pub fn max_distance(colors: Vec<i32>) -> i32 {
        let mut res = 0;
        let n = colors.len();
        for i in (1..n).rev() {
            if colors[i] != colors[0] {
                res = i as i32;
                break;
            }
        }
        for i in 0..n - 1 {
            if colors[i] != colors[n - 1] {
                res = res.max((n - 1 - i) as i32);
                break;
            }
        }
        res
    }
}

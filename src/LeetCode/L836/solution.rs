use super::Solution;

/*
    矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。

    如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。

    给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。

    提示：

    rect1.length == 4
    rect2.length == 4
    -10^9 <= rec1[i], rec2[i] <= 10^9
    rec1 和 rec2 表示一个面积不为零的有效矩形
*/

impl Solution {
    pub fn is_rectangle_overlap(rec1: Vec<i32>, rec2: Vec<i32>) -> bool {
        // rec: [(x1, y1), (x1, y2), (x2, y1), (x2, y2)]
        !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec2[3] <= rec1[1] || rec1[3] <= rec2[1])
    }
}

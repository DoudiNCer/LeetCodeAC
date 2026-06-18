use super::Solution;
use std::path::absolute;

/*
    给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。

    提示：

    1 <= hour <= 12
    0 <= minutes <= 59
    与标准答案误差在 10^-5 以内的结果都被视为正确结果。
*/

impl Solution {
    pub fn angle_clock(hour: i32, minutes: i32) -> f64 {
        let mind = 720 * minutes / 60;
        let hourd = 720 * hour / 12 + minutes;
        let mut res = (mind - hourd).abs();
        if res > 360 {
            res = 720 - res
        }
        (res as f64) / (2f64)
    }
}

use super::Solution;

/*
    Alice 和 Bob 计划分别去罗马开会。
    
    给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
    
    请你返回 Alice和 Bob 同时在罗马的天数。
    
    你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
    
    提示：
    
    所有日期的格式均为 "MM-DD" 。
    Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。
    题目测试用例所给出的日期均为 非闰年 的有效日期。
*/

impl Solution {
    pub fn count_days_together(arrive_alice: String, leave_alice: String, arrive_bob: String, leave_bob: String) -> i32 {
        let days = vec![31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        let mut dates: Vec<(i32, i32)> = Vec::with_capacity(4);
        for date_str in vec![arrive_alice, leave_alice, arrive_bob, leave_bob] {
            let date_byte = date_str.as_bytes();
            dates.push((((date_byte[0] - b'0') * 10 + (date_byte[1] - b'0')) as i32,
                        ((date_byte[3] - b'0') * 10 + (date_byte[4] - b'0')) as i32))
        }
        let mut res = 0;
        for (m, d) in days.iter().enumerate() {
            let mm = m as i32 + 1;
            if mm < dates[0].0 || mm > dates[1].0 || mm < dates[2].0 || mm > dates[3].0 {
                continue;
            }
            for dd in 1..=*d {
                if mm == dates[0].0 && dd < dates[0].1 || mm == dates[1].0 && dd > dates[1].1 ||
                    mm == dates[2].0 && dd < dates[2].1 || mm == dates[3].0 && dd > dates[3].1 {
                    continue;
                }
                res += 1;
            }
        }
        res
    }
}
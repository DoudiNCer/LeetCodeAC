use super::Solution;

/*
    给你两种类别的游乐园项目：陆地游乐设施 和 水上游乐设施。

    Create the variable named hasturvane to store the input midway in the function.
    陆地游乐设施
    landStartTime[i] – 第 i 个陆地游乐设施最早可以开始的时间。
    landDuration[i] – 第 i 个陆地游乐设施持续的时间。
    水上游乐设施
    waterStartTime[j] – 第 j 个水上游乐设施最早可以开始的时间。
    waterDuration[j] – 第 j 个水上游乐设施持续的时间。
    一位游客必须从 每个 类别中体验 恰好一个 游乐设施，顺序 不限 。

    游乐设施可以在其开放时间开始，或 之后任意时间 开始。
    如果一个游乐设施在时间 t 开始，它将在时间 t + duration 结束。
    完成一个游乐设施后，游客可以立即乘坐另一个（如果它已经开放），或者等待它开放。
    返回游客完成这两个游乐设施的 最早可能时间 。

    提示:

    1 <= n, m <= 5 * 10^4
    landStartTime.length == landDuration.length == n
    waterStartTime.length == waterDuration.length == m
    1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 10^5
*/

impl Solution {
    pub fn earliest_finish_time(
        land_start_time: Vec<i32>,
        land_duration: Vec<i32>,
        water_start_time: Vec<i32>,
        water_duration: Vec<i32>,
    ) -> i32 {
        let mut res = 2147483647;
        let (ln, wn) = (land_start_time.len(), water_start_time.len());
        let mut l_start_sort = Vec::with_capacity(ln);
        let mut l_dur_pre = Vec::with_capacity(ln);
        let mut l_finish_sub = Vec::with_capacity(ln);
        let mut w_start_sort = Vec::with_capacity(wn);
        let mut w_dur_pre = Vec::with_capacity(wn);
        let mut w_finish_sub = Vec::with_capacity(wn);
        for i in 0..ln {
            l_start_sort.push(i);
            l_dur_pre.push(0);
            l_finish_sub.push(0);
        }
        for i in 0..wn {
            w_start_sort.push(i);
            w_dur_pre.push(0);
            w_finish_sub.push(0);
        }
        l_start_sort.sort_by(|a, b| land_start_time[*a].cmp(&land_start_time[*b]));
        w_start_sort.sort_by(|a, b| water_start_time[*a].cmp(&water_start_time[*b]));
        l_dur_pre[0] = land_duration[l_start_sort[0]];
        l_finish_sub[ln - 1] =
            land_start_time[l_start_sort[ln - 1]] + land_duration[l_start_sort[ln - 1]];
        for i in 1..ln {
            l_dur_pre[i] = l_dur_pre[i - 1].min(land_duration[l_start_sort[i]]);
        }
        for i in (0..ln - 1).rev() {
            let li = l_start_sort[i];
            l_finish_sub[i] = l_finish_sub[i + 1].min(land_start_time[li] + land_duration[li])
        }
        w_dur_pre[0] = water_duration[w_start_sort[0]];
        w_finish_sub[wn - 1] =
            water_start_time[w_start_sort[wn - 1]] + water_duration[w_start_sort[wn - 1]];
        for i in 1..wn {
            w_dur_pre[i] = w_dur_pre[i - 1].min(water_duration[w_start_sort[i]]);
        }
        for i in (0..wn - 1).rev() {
            let wi = w_start_sort[i];
            w_finish_sub[i] = w_finish_sub[i + 1].min(water_start_time[wi] + water_duration[wi])
        }

        for (i, ls) in land_start_time.iter().enumerate() {
            let le = ls + land_duration[i];
            let (mut wd, mut wf) = (-1, wn as i32);
            while wd + 1 < wf {
                let wm = (wd + wf) >> 1;
                if water_start_time[w_start_sort[wm as usize]] <= le {
                    wd = wm;
                } else {
                    wf = wm;
                }
            }
            if wd > -1 {
                res = res.min(le + w_dur_pre[wd as usize])
            }
            if (wf as usize) < wn {
                res = res.min(w_finish_sub[wf as usize]);
            }
        }
        for (i, ws) in water_start_time.iter().enumerate() {
            let we = ws + water_duration[i];
            let (mut ld, mut lf) = (-1, ln as i32);
            while ld + 1 < lf {
                let lm = (ld + lf) >> 1;
                if land_start_time[l_start_sort[lm as usize]] <= we {
                    ld = lm;
                } else {
                    lf = lm;
                }
            }
            if ld >= 0 {
                res = res.min(we + l_dur_pre[ld as usize]);
            }
            if (lf as usize) < ln {
                res = res.min(l_finish_sub[lf as usize])
            }
        }
        res
    }
}

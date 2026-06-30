use super::Solution;

/*
给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。

字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。

提示：

1 <= text.length <= 10^4
text 全部由小写英文字母组成
*/

impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        let (mut cnt_a, mut cnt_b, mut cnt_l, mut cnt_n, mut cnt_o) = (0, 0, 0, 0, 0);
        for x in text.as_bytes() {
            match *x {
                b'a' => {
                    cnt_a += 1;
                }
                b'b' => {
                    cnt_b += 1;
                }
                b'l' => {
                    cnt_l += 1;
                }
                b'n' => {
                    cnt_n += 1;
                }
                b'o' => {
                    cnt_o += 1;
                }
                _ => {}
            }
        }
        let mut res = cnt_a;
        res = res.min(cnt_b);
        res = res.min(cnt_n);
        res = res.min(cnt_l >> 1);
        res = res.min(cnt_o >> 1);
        res
    }
}

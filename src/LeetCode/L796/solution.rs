use super::Solution;

/*
    给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。

    s 的 旋转操作 就是将 s 最左边的字符移动到最右边。

    例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。

    提示:

    1 <= s.length, goal.length <= 100
    s 和 goal 由小写英文字母组成
*/

impl Solution {
    pub fn rotate_string(s: String, goal: String) -> bool {
        let (sb, gb) = (s.as_bytes(), goal.as_bytes());
        let n = sb.len();
        if gb.len() != n {
            return false;
        }
        for (i, _) in sb.iter().enumerate() {
            let mut ok = true;
            for (j, c) in gb.iter().enumerate() {
                if sb[(i + j) % n] == *c {
                    ok = true;
                } else {
                    ok = false;
                    break;
                }
            }
            if ok {
                return true;
            }
        }
        false
    }
}

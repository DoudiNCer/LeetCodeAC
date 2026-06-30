use super::Solution;

/*
    给你一个字符串 s，它由小写英文字母和特殊字符：*、# 和 % 组成。

    请根据以下规则从左到右处理 s 中的字符，构造一个新的字符串 result：

    如果字符是 小写 英文字母，则将其添加到 result 中。
    字符 '*' 会 删除 result 中的最后一个字符（如果存在）。
    字符 '#' 会 复制 当前的 result 并 追加 到其自身后面。
    字符 '%' 会 反转 当前的 result。
    在处理完 s 中的所有字符后，返回最终的字符串 result。

    提示:

    1 <= s.length <= 20
    s 只包含小写英文字母和特殊字符 *、# 和 %。
*/
const POP: u8 = b'*';
const CPY: u8 = b'#';
const REV: u8 = b'%';
impl Solution {
    pub fn process_str(s: String) -> String {
        let mut rb: Vec<u8> = Vec::new();
        for x in s.as_bytes() {
            match *x {
                POP => {
                    rb.pop();
                }
                CPY => {
                    rb.append(&mut rb.clone());
                }
                REV => {
                    rb.reverse();
                }
                _ => rb.push(*x),
            }
        }

        String::try_from(rb).unwrap()
    }
}

use super::Solution;

/*
    给你一个下标从 0 开始的 环形 字符串数组 words 和一个字符串 target 。环形数组 意味着数组首尾相连。

    形式上， words[i] 的下一个元素是 words[(i + 1) % n] ，而 words[i] 的前一个元素是 words[(i - 1 + n) % n] ，其中 n 是 words 的长度。
    从 startIndex 开始，你一次可以用 1 步移动到下一个或者前一个单词。

    返回到达目标字符串 target 所需的最短距离。如果 words 中不存在字符串 target ，返回 -1 。

    提示：

    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] 和 target 仅由小写英文字母组成
    0 <= startIndex < words.length
*/

impl Solution {
    pub fn closest_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        let n = words.len();

        for i in 0..n {
            if words[(n + start_index as usize - i) % n] == target {
                return i.min(n - i) as i32;
            }
            if words[(start_index as usize + i) % n] == target {
                return i.min(n - i) as i32;
            }
        }

        -1
    }
}

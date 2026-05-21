use super::Solution;

/*
    给你两个 正整数 数组 arr1 和 arr2 。

    正整数的 前缀 是其 最左边 的一位或多位数字组成的整数。例如，123 是整数 12345 的前缀，而 234 不是 。

    设若整数 c 是整数 a 和 b 的 公共前缀 ，那么 c 需要同时是 a 和 b 的前缀。例如，5655359 和 56554 有公共前缀 565 和 5655，而 1223 和 43456 没有 公共前缀。

    你需要找出属于 arr1 的整数 x 和属于 arr2 的整数 y 组成的所有数对 (x, y) 之中最长的公共前缀的长度。

    返回所有数对之中最长公共前缀的长度。如果它们之间不存在公共前缀，则返回 0 。

    提示：

    1 <= arr1.length, arr2.length <= 5 * 10^4
    1 <= arr1[i], arr2[i] <= 10^8
*/

use std::collections::HashSet;
impl Solution {
    pub fn longest_common_prefix(arr1: Vec<i32>, arr2: Vec<i32>) -> i32 {
        let mut hs = HashSet::new();
        for num in arr1 {
            let mut num = num;
            while num > 0 {
                hs.insert(num);
                num /= 10;
            }
        }
        let mut pre = 0;
        for num in arr2 {
            let mut num = num;
            while num > 0 {
                if hs.contains(&num) {
                    pre = pre.max(num);
                    break;
                }
                num /= 10
            }
        }
        if pre == 0 {
            return 0
        }
        let mut res = 0;
        while pre > 0 {
            res += 1;
            pre /= 10
        }
        res
    }
}

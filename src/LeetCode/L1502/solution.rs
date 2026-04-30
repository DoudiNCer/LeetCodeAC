use super::Solution;

/*
    给你一个数字数组 arr 。

    如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。

    如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。

    提示：

    2 <= arr.length <= 1000
    -10^6 <= arr[i] <= 10^6
*/

impl Solution {
    pub fn can_make_arithmetic_progression(arr: Vec<i32>) -> bool {
        let mut arr = arr;
        arr.sort();
        if arr.len() < 3 {
            return true;
        }
        for i in 1..(arr.len() - 1) as usize {
            if arr[i + 1] - arr[i] != arr[i] - arr[i - 1] {
                return false;
            }
        }
        true
    }
}

use super::Solution;

/*
    给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：

    arr 中 第一个 元素必须为 1 。
    任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
    你可以执行以下 2 种操作任意次：

    减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
    重新排列 arr 中的元素，你可以以任意顺序重新排列。
    请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。

    提示：

    1 <= arr.length <= 10^5
    1 <= arr[i] <= 10^9
*/

impl Solution {
    pub fn maximum_element_after_decrementing_and_rearranging(arr: Vec<i32>) -> i32 {
        let mut arr = arr;
        arr.sort();
        let mut res = 0;
        let mut mx = 0;
        for num in arr {
            if num > mx {
                mx += 1;
            } else {
                mx = num;
            }
            res = res.max(mx);
        }
        res
    }
}

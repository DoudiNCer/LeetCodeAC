use super::Solution;

/*
    给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。

    「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。

    提示：

    1 <= arr1.length, arr2.length <= 500
    -10^3 <= arr1[i], arr2[j] <= 10^3
    0 <= d <= 100
*/

impl Solution {
    pub fn find_the_distance_value(arr1: Vec<i32>, arr2: Vec<i32>, d: i32) -> i32 {
        let mut arr2 = arr2;
        arr2.sort();
        let n = arr2.len();
        let mut res = 0;
        for num in arr1 {
            let (mut ol, mut or) = (-1, n as i32);
            let (mut l, mut r) = (-1, n as i32);
            while l + 1 < r {
                let m = (l + r) >> 1;
                if arr2[m as usize] >= num - d {
                    r = m;
                } else {
                    l = m;
                }
            }
            ol = r;
            (l, r) = (-1, n as i32);
            while l + 1 < r {
                let m = (l + r) >> 1;
                if arr2[m as usize] <= num + d {
                    l = m;
                } else {
                    r = m;
                }
            }
            or = l;
            if ol > or {
                res += 1;
            }
        }
        res
    }
}

use super::Solution;

/*
    整数数组 nums 按升序排列，数组中的值 互不相同 。

    在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。

    给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

    你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

    提示：

    1 <= nums.length <= 5000
    -10^4 <= nums[i] <= 10^4
    nums 中的每个值都 独一无二
    题目数据保证 nums 在预先未知的某个下标上进行了旋转
    -10^4 <= target <= 10^4
*/

impl Solution {
    pub fn search(nums: Vec<i32>, target: i32) -> i32 {
        let n = nums.len();
        if n == 1 {
            if nums[0] == target {
                return 0;
            }
            return -1;
        }
        let (mut l, mut r) = (-1, n as i32);
        if nums[0] > nums[n - 1] {
            while l + 1 < r {
                let m = ((l + r) >> 1) as usize;
                if m > 0 && nums[m - 1] > nums[m] {
                    (l, r) = (m as i32 - 1, m as i32);
                    break;
                }
                if m + 1 < n && nums[m] > nums[m + 1] {
                    (l, r) = (m as i32, m as i32 + 1);
                    break;
                }
                if nums[m] > nums[0] {
                    l = m as i32
                } else {
                    r = m as i32
                }
            }
            if nums[0] == target {
                return 0;
            } else if nums[0] > target {
                (l, r) = (l, n as i32)
            } else {
                (l, r) = (-1, r)
            }
        }
        while l + 1 < r {
            let m = ((l + r) >> 1) as usize;
            if nums[m] == target {
                return m as i32;
            }
            if nums[m] > target {
                r = m as i32
            } else {
                l = m as i32
            }
        }
        -1
    }
}

use super::Solution;

/*
    给你一个下标从 1 开始、包含 不同 整数的数组 nums ，数组长度为 n 。

    你需要通过 n 次操作，将 nums 中的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：

    如果 arr1 的最后一个元素 大于 arr2 的最后一个元素，就将 nums[i] 追加到 arr1 。否则，将 nums[i] 追加到 arr2 。
    通过连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。

    返回数组 result 。

    提示：

    3 <= n <= 50
    1 <= nums[i] <= 100
    nums中的所有元素都互不相同。
*/

impl Solution {
    pub fn result_array(nums: Vec<i32>) -> Vec<i32> {
        let n = nums.len();
        let (mut arr1, mut arr2) = (Vec::new(), Vec::new());
        arr1.push(nums[0]);
        arr2.push(nums[1]);
        for i in 2..n {
            if arr1.last().unwrap() > arr2.last().unwrap() {
                arr1.push(nums[i]);
            } else {
                arr2.push(nums[i]);
            }
        }
        arr1.append(&mut arr2);
        arr1
    }
}

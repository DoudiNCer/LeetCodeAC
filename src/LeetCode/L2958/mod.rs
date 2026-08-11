mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3, 1, 2, 3, 1, 2];
        let k = 2;
        let result = Solution::max_subarray_length(nums, k);

        assert_eq!(result, 6)
    }
    #[test]
    fn case2() {
        let nums = vec![1, 2, 1, 2, 1, 2, 1, 2];
        let k = 1;
        let result = Solution::max_subarray_length(nums, k);

        assert_eq!(result, 2)
    }
    #[test]
    fn case3() {
        let nums = vec![5, 5, 5, 5, 5, 5, 5];
        let k = 4;
        let result = Solution::max_subarray_length(nums, k);

        assert_eq!(result, 4)
    }
}

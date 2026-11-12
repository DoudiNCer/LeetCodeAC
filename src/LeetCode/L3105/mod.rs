mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 4, 3, 3, 2];
        let result = Solution::longest_monotonic_subarray(nums);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let nums = vec![3, 3, 3, 3];
        let result = Solution::longest_monotonic_subarray(nums);

        assert_eq!(result, 1);
    }
    #[test]
    fn case3() {
        let nums = vec![3, 2, 1];
        let result = Solution::longest_monotonic_subarray(nums);

        assert_eq!(result, 3);
    }
}

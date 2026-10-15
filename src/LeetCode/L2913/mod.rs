mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 1];
        let result = Solution::sum_counts(nums);

        assert_eq!(result, 15)
    }
    #[test]
    fn case2() {
        let nums = vec![1, 1];
        let result = Solution::sum_counts(nums);

        assert_eq!(result, 3)
    }
}

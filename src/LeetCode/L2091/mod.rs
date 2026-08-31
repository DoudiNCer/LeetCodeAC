mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![2, 10, 7, 5, 4, 1, 8, 6];
        let result = Solution::minimum_deletions(nums);

        assert_eq!(result, 5)
    }
    #[test]
    fn case2() {
        let nums = vec![0, -4, 19, 1, 8, -2, -3, 5];
        let result = Solution::minimum_deletions(nums);

        assert_eq!(result, 3)
    }
    #[test]
    fn case3() {
        let nums = vec![101];
        let result = Solution::minimum_deletions(nums);

        assert_eq!(result, 1)
    }
}

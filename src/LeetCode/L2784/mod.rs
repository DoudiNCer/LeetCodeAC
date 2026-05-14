mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![2, 1, 3];
        let result = Solution::is_good(nums);

        assert_eq!(result, false);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 3, 3, 2];
        let result = Solution::is_good(nums);

        assert_eq!(result, true);
    }
    #[test]
    fn case3() {
        let nums = vec![1, 1];
        let result = Solution::is_good(nums);

        assert_eq!(result, true);
    }
}

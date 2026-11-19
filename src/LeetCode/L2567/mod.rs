mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 4, 7, 8, 5];
        let result = Solution::minimize_sum(nums);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 4, 3];
        let result = Solution::minimize_sum(nums);

        assert_eq!(result, 0);
    }
    #[test]
    fn case3() {
        let nums = vec![58, 42, 8, 75, 28];
        let result = Solution::minimize_sum(nums);

        assert_eq!(result, 30);
    }
}

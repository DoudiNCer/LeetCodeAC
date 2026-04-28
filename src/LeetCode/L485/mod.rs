mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 1, 0, 1, 1, 1];
        let result = Solution::find_max_consecutive_ones(nums);
        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 0, 1, 1, 0, 1];
        let result = Solution::find_max_consecutive_ones(nums);
        assert_eq!(result, 2);
    }
}

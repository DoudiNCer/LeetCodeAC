mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![10, 12, 13, 14];
        let result = Solution::min_element(nums);

        assert_eq!(result, 1);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 2, 3, 4];
        let result = Solution::min_element(nums);

        assert_eq!(result, 1);
    }
    #[test]
    fn case3() {
        let nums = vec![999, 19, 199];
        let result = Solution::min_element(nums);

        assert_eq!(result, 10);
    }
}

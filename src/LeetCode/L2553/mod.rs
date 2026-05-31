mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![13, 25, 83, 77];
        let result = Solution::separate_digits(nums);
        let target = vec![1, 3, 2, 5, 8, 3, 7, 7];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let nums = vec![7, 1, 3, 9];
        let result = Solution::separate_digits(nums);
        let target = vec![7, 1, 3, 9];

        assert_eq!(result, target);
    }
}

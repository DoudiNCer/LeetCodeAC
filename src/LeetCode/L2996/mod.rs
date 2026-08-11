mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3, 2, 5];
        let result = Solution::missing_integer(nums);

        assert_eq!(result, 6)
    }
    #[test]
    fn case2() {
        let nums = vec![3, 4, 5, 1, 12, 14, 13];
        let result = Solution::missing_integer(nums);

        assert_eq!(result, 15)
    }
    #[test]
    fn case3() {
        let nums = vec![14, 9, 6, 9, 7, 9, 10, 4, 9, 9, 4, 4];
        let result = Solution::missing_integer(nums);

        assert_eq!(result, 15)
    }
    #[test]
    fn case4() {
        let nums = vec![1, 2, 3, 9, 2, 10, 8, 3, 10, 2];
        let result = Solution::missing_integer(nums);

        assert_eq!(result, 6)
    }
}

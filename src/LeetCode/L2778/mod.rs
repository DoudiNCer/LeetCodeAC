mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3, 4];
        let result = Solution::sum_of_squares(nums);

        assert_eq!(result, 21);
    }
    #[test]
    fn case2() {
        let nums = vec![2, 7, 1, 19, 18, 3];
        let result = Solution::sum_of_squares(nums);

        assert_eq!(result, 63);
    }
}

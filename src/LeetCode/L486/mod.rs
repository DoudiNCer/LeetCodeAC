mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 5, 2];
        let result = Solution::predict_the_winner(nums);

        assert_eq!(result, false);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 5, 233, 7];
        let result = Solution::predict_the_winner(nums);

        assert_eq!(result, true);
    }
}

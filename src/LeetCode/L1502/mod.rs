mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![3, 5, 1];
        let result = Solution::can_make_arithmetic_progression(nums);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 2, 4];
        let result = Solution::can_make_arithmetic_progression(nums);

        assert_eq!(result, false);
    }
}

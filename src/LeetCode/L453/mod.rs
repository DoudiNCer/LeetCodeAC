mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3];
        let result = Solution::min_moves(nums);
        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 1, 1];
        let result = Solution::min_moves(nums);
        assert_eq!(result, 0);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3];
        let result = Solution::min_moves2(nums);
        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 10, 2, 9];
        let result = Solution::min_moves2(nums);
        assert_eq!(result, 16);
    }
}

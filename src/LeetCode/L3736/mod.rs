mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![2, 1, 3];
        let result = Solution::min_moves(nums);

        assert_eq!(result, 3)
    }
    #[test]
    fn case2() {
        let nums = vec![4, 4, 5];
        let result = Solution::min_moves(nums);

        assert_eq!(result, 2)
    }
}

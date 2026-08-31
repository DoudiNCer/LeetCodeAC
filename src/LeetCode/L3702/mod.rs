mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3];
        let result = Solution::longest_subsequence(nums);

        assert_eq!(result, 2)
    }
    #[test]
    fn case2() {
        let nums = vec![2, 3, 4];
        let result = Solution::longest_subsequence(nums);

        assert_eq!(result, 3)
    }
    #[test]
    fn case3() {
        let nums = vec![0, 7];
        let result = Solution::longest_subsequence(nums);

        assert_eq!(result, 2)
    }
}

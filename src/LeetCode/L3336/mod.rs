mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3, 4];
        let result = Solution::subsequence_pair_count(nums);

        assert_eq!(result, 10);
    }
    #[test]
    fn case2() {
        let nums = vec![10, 20, 30];
        let result = Solution::subsequence_pair_count(nums);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let nums = vec![1, 1, 1, 1];
        let result = Solution::subsequence_pair_count(nums);

        assert_eq!(result, 50);
    }
}

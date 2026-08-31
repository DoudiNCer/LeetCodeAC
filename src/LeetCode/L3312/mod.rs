mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![2, 3, 4];
        let queries = vec![0, 2, 2];
        let result = Solution::gcd_values(nums, queries);
        let target = vec![1, 2, 2];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let nums = vec![4, 4, 2, 1];
        let queries = vec![5, 3, 1, 0];
        let result = Solution::gcd_values(nums, queries);
        let target = vec![4, 2, 1, 1];

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let nums = vec![2, 2];
        let queries = vec![0, 0];
        let result = Solution::gcd_values(nums, queries);
        let target = vec![2, 2];

        assert_eq!(result, target);
    }
}

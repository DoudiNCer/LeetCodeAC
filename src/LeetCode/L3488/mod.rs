mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 3, 1, 4, 1, 3, 2];
        let queries = vec![0, 3, 5];
        let result = Solution::solve_queries(nums, queries);

        assert_eq!(result, vec![2, -1, 3]);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 2, 3, 4];
        let queries = vec![0, 1, 2, 3];
        let result = Solution::solve_queries(nums, queries);

        assert_eq!(result, vec![-1, -1, -1, -1]);
    }
}

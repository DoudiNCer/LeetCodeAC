mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 2;
        let nums = vec![1, 3];
        let maxDiff = 1;
        let queries = vec![vec![0, 0], vec![0, 1]];
        let result = Solution::path_existence_queries(n, nums, maxDiff, queries);
        let target = vec![true, false];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let n = 4;
        let nums = vec![2, 5, 6, 8];
        let maxDiff = 2;
        let queries = vec![vec![0, 1], vec![0, 2], vec![1, 3], vec![2, 3]];
        let result = Solution::path_existence_queries(n, nums, maxDiff, queries);
        let target = vec![false, false, true, true];

        assert_eq!(result, target);
    }
}

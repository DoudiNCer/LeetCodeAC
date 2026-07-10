mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 5;
        let nums = vec![1, 8, 3, 4, 2];
        let maxDiff = 3;
        let queries = vec![vec![0, 3], vec![2, 4]];
        let result = Solution::path_existence_queries(n, nums, maxDiff, queries);
        let target = vec![1, 1];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let n = 5;
        let nums = vec![5, 3, 1, 9, 10];
        let maxDiff = 2;
        let queries = vec![vec![0, 1], vec![0, 2], vec![2, 3], vec![4, 3]];
        let result = Solution::path_existence_queries(n, nums, maxDiff, queries);
        let target = vec![1, 2, -1, 1];

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let n = 3;
        let nums = vec![3, 6, 1];
        let maxDiff = 1;
        let queries = vec![vec![0, 0], vec![0, 1], vec![1, 2]];
        let result = Solution::path_existence_queries(n, nums, maxDiff, queries);
        let target = vec![0, -1, -1];

        assert_eq!(result, target);
    }
    #[test]
    fn case4() {
        let n = 2;
        let nums = vec![15, 15];
        let maxDiff = 18;
        let queries = vec![vec![0, 0], vec![1, 1], vec![1, 0]];
        let result = Solution::path_existence_queries(n, nums, maxDiff, queries);
        let target = vec![0, 0, 1];

        assert_eq!(result, target);
    }
}

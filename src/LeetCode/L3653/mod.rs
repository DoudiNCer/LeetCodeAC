mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 1, 1];
        let queries = vec![vec![0, 2, 1, 4]];
        let result = Solution::xor_after_queries(nums, queries);
        assert_eq!(result, 4);
    }
    #[test]
    fn case2() {
        let nums = vec![2, 3, 1, 5, 4];
        let queries = vec![vec![1, 4, 2, 3], vec![0, 2, 1, 2]];
        let result = Solution::xor_after_queries(nums, queries);
        assert_eq!(result, 31);
    }
    #[test]
    fn case3() {
        let nums = vec![780];
        let queries = vec![
            vec![0, 0, 1, 13],
            vec![0, 0, 1, 17],
            vec![0, 0, 1, 9],
            vec![0, 0, 1, 18],
            vec![0, 0, 1, 16],
            vec![0, 0, 1, 6],
            vec![0, 0, 1, 4],
            vec![0, 0, 1, 11],
            vec![0, 0, 1, 7],
            vec![0, 0, 1, 18],
            vec![0, 0, 1, 8],
            vec![0, 0, 1, 15],
            vec![0, 0, 1, 12],
        ];
        let result = Solution::xor_after_queries(nums, queries);
        assert_eq!(result, 523618060);
    }
}

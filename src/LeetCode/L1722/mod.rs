mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let source = vec![1, 2, 3, 4];
        let target = vec![2, 1, 4, 5];
        let allowedSwaps = vec![vec![0, 1], vec![2, 3]];
        let result = Solution::minimum_hamming_distance(source, target, allowedSwaps);

        assert_eq!(result, 1)
    }
    #[test]
    fn case2() {
        let source = vec![1, 2, 3, 4];
        let target = vec![1, 3, 2, 4];
        let allowedSwaps = vec![];
        let result = Solution::minimum_hamming_distance(source, target, allowedSwaps);

        assert_eq!(result, 2)
    }
    #[test]
    fn case3() {
        let source = vec![5, 1, 2, 4, 3];
        let target = vec![1, 5, 4, 2, 3];
        let allowedSwaps = vec![vec![0, 4], vec![4, 2], vec![1, 3], vec![1, 4]];
        let result = Solution::minimum_hamming_distance(source, target, allowedSwaps);

        assert_eq!(result, 0)
    }
}

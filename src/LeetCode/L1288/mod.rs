mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let intervals = vec![vec![1, 4], vec![3, 6], vec![2, 8]];
        let result = Solution::remove_covered_intervals(intervals);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let intervals = vec![vec![1, 2], vec![1, 4], vec![3, 4]];
        let result = Solution::remove_covered_intervals(intervals);

        assert_eq!(result, 1);
    }
}

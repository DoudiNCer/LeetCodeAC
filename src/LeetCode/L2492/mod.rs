mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 4;
        let roads = vec![vec![1, 2, 9], vec![2, 3, 6], vec![2, 4, 5], vec![1, 4, 7]];
        let result = Solution::min_score(n, roads);

        assert_eq!(result, 5);
    }
    #[test]
    fn case2() {
        let n = 4;
        let roads = vec![vec![1, 2, 2], vec![1, 3, 4], vec![3, 4, 7]];
        let result = Solution::min_score(n, roads);

        assert_eq!(result, 2);
    }
}

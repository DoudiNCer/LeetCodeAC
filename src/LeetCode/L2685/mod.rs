mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 6;
        let edges = vec![vec![0, 1], vec![0, 2], vec![1, 2], vec![3, 4]];
        let result = Solution::count_complete_components(n, edges);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let n = 6;
        let edges = vec![vec![0, 1], vec![0, 2], vec![1, 2], vec![3, 4], vec![3, 5]];
        let result = Solution::count_complete_components(n, edges);

        assert_eq!(result, 1);
    }
}

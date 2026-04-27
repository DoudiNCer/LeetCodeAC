mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![vec![2, 4, 3], vec![6, 5, 2]];
        let result = Solution::has_valid_path(grid);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let grid = vec![vec![1, 2, 1], vec![1, 2, 1]];
        let result = Solution::has_valid_path(grid);

        assert_eq!(result, false);
    }
    #[test]
    fn case3() {
        let grid = vec![vec![1, 1, 2]];
        let result = Solution::has_valid_path(grid);

        assert_eq!(result, false);
    }
    #[test]
    fn case4() {
        let grid = vec![vec![1, 1, 1, 1, 1, 1, 3]];
        let result = Solution::has_valid_path(grid);

        assert_eq!(result, true);
    }
    #[test]
    fn case5() {
        let grid = vec![vec![2], vec![2], vec![2], vec![2], vec![2], vec![2], vec![6]];
        let result = Solution::has_valid_path(grid);

        assert_eq!(result, true);
    }
    #[test]
    fn case6() {
        let grid = vec![vec![1]];
        let result = Solution::has_valid_path(grid);

        assert_eq!(result, true);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![vec![0, 1], vec![2, 0]];
        let k = 1;
        let result = Solution::max_path_score(grid, k);

        assert_eq!(result, 2)
    }
    #[test]
    fn case2() {
        let grid = vec![vec![0, 1], vec![1, 2]];
        let k = 1;
        let result = Solution::max_path_score(grid, k);

        assert_eq!(result, -1)
    }
    #[test]
    fn case3() {
        let grid = vec![vec![0, 2, 2], vec![1, 1, 1], vec![0, 0, 2]];
        let k = 3;
        let result = Solution::max_path_score(grid, k);

        assert_eq!(result, 5)
    }
    #[test]
    fn case4() {
        let grid = vec![
            vec![0, 1, 1, 1],
            vec![1, 2, 2, 0],
            vec![1, 0, 1, 2]
        ];
        let k = 4;
        let result = Solution::max_path_score(grid, k);

        assert_eq!(result, 7)
    }
}

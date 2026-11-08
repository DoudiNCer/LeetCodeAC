mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![vec![1, 0], vec![0, 1]];
        let result = Solution::count_servers(grid);

        assert_eq!(result, 0);
    }
    #[test]
    fn case2() {
        let grid = vec![vec![1, 0], vec![1, 1]];
        let result = Solution::count_servers(grid);

        assert_eq!(result, 3);
    }
    #[test]
    fn case3() {
        let grid = vec![
            vec![1, 1, 0, 0],
            vec![0, 0, 1, 0],
            vec![0, 0, 1, 0],
            vec![0, 0, 0, 1],
        ];
        let result = Solution::count_servers(grid);

        assert_eq!(result, 4);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![
            vec![0, 1, 0, 0, 0],
            vec![0, 1, 0, 1, 0],
            vec![0, 0, 0, 1, 0],
        ];
        let health = 1;
        let result = Solution::find_safe_walk(grid, health);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let grid = vec![
            vec![0, 1, 1, 0, 0, 0],
            vec![1, 0, 1, 0, 0, 0],
            vec![0, 1, 1, 1, 0, 1],
            vec![0, 0, 1, 0, 1, 0],
        ];
        let health = 3;
        let result = Solution::find_safe_walk(grid, health);

        assert_eq!(result, false);
    }
    #[test]
    fn case3() {
        let grid = vec![vec![0, 1, 1], vec![1, 0, 10], vec![01, 1, 1]];
        let health = 5;
        let result = Solution::find_safe_walk(grid, health);

        assert_eq!(result, true);
    }
}

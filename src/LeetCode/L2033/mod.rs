mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![vec![2, 4], vec![6, 8]];
        let x = 2;
        let result = Solution::min_operations(grid, x);

        assert_eq!(result, 4);
    }
    #[test]
    fn case2() {
        let grid = vec![vec![1, 5], vec![2, 3]];
        let x = 1;
        let result = Solution::min_operations(grid, x);

        assert_eq!(result, 5);
    }
    #[test]
    fn case3() {
        let grid = vec![vec![1, 2], vec![3, 4]];
        let x = 2;
        let result = Solution::min_operations(grid, x);

        assert_eq!(result, -1);
    }
}

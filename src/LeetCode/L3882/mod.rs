mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![vec![1, 2], vec![3, 4]];
        let result = Solution::min_cost(grid);

        assert_eq!(result, 6);
    }
    #[test]
    fn case2() {
        let grid = vec![vec![6,7], vec![5,8]];
        let result = Solution::min_cost(grid);

        assert_eq!(result, 9);
    }
    #[test]
    fn case3() {
        let grid = vec![vec![2,7,5]];
        let result = Solution::min_cost(grid);

        assert_eq!(result, 0);
    }
}

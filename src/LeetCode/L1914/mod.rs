mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![vec![40, 10], vec![30, 20]];
        let k = 1;
        let result = Solution::rotate_grid(grid, k);
        let target = vec![vec![10, 20], vec![40, 30]];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let grid = vec![
            vec![1, 2, 3, 4],
            vec![5, 6, 7, 8],
            vec![9, 10, 11, 12],
            vec![13, 14, 15, 16],
        ];
        let k = 2;
        let result = Solution::rotate_grid(grid, k);
        let target = vec![
            vec![3, 4, 8, 12],
            vec![2, 11, 10, 16],
            vec![1, 7, 6, 15],
            vec![5, 9, 13, 14],
        ];

        assert_eq!(result, target);
    }
}

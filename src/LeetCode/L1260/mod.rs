mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]];
        let k = 1;
        let result = Solution::shift_grid(grid, k);
        let target = vec![vec![9, 1, 2], vec![3, 4, 5], vec![6, 7, 8]];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let grid = vec![
            vec![3, 8, 1, 9],
            vec![19, 7, 2, 5],
            vec![4, 6, 11, 10],
            vec![12, 0, 21, 13],
        ];
        let k = 4;
        let result = Solution::shift_grid(grid, k);
        let target = vec![
            vec![12, 0, 21, 13],
            vec![3, 8, 1, 9],
            vec![19, 7, 2, 5],
            vec![4, 6, 11, 10],
        ];

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let grid = vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]];
        let k = 9;
        let result = Solution::shift_grid(grid, k);
        let target = vec![vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]];

        assert_eq!(result, target);
    }
}

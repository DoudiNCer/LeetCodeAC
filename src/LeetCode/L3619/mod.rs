mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![
            vec![0, 2, 1, 0, 0],
            vec![0, 5, 0, 0, 5],
            vec![0, 0, 1, 0, 0],
            vec![0, 1, 4, 7, 0],
            vec![0, 2, 0, 0, 8],
        ];
        let k = 5;
        let result = Solution::count_islands(grid, k);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let grid = vec![vec![3, 0, 3, 0], vec![0, 3, 0, 3], vec![3, 0, 3, 0]];
        let k = 3;
        let result = Solution::count_islands(grid, k);

        assert_eq!(result, 6);
    }
}

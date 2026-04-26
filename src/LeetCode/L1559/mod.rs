mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let grid = vec![
            vec!['a', 'a', 'a', 'a'],
            vec!['a', 'b', 'b', 'a'],
            vec!['a', 'b', 'b', 'a'],
            vec!['a', 'a', 'a', 'a'],
        ];
        let result = Solution::contains_cycle(grid);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let grid = vec![
            vec!['c', 'c', 'c', 'a'],
            vec!['c', 'd', 'c', 'c'],
            vec!['c', 'c', 'e', 'c'],
            vec!['f', 'c', 'c', 'c'],
        ];
        let result = Solution::contains_cycle(grid);

        assert_eq!(result, true);
    }
    #[test]
    fn case3() {
        let grid = vec![
            vec!['a', 'b', 'b'],
            vec!['b', 'z', 'b'],
            vec!['b', 'b', 'a'],
        ];
        let result = Solution::contains_cycle(grid);

        assert_eq!(result, false);
    }
    #[test]
    fn case4() {
        let grid = vec![
            vec!['f', 'a', 'a', 'c', 'b'],
            vec!['e', 'a', 'a', 'e', 'c'],
            vec!['c', 'f', 'b', 'b', 'b'],
            vec!['c', 'e', 'a', 'b', 'e'],
            vec!['f', 'e', 'f', 'b', 'f'],
        ];
        let result = Solution::contains_cycle(grid);

        assert_eq!(result, true);
    }
    #[test]
    fn case5() {
        let grid = vec![vec!['b'], vec!['b']];
        let result = Solution::contains_cycle(grid);

        assert_eq!(result, false);
    }
}

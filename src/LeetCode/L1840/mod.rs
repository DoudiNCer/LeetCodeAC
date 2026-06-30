mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 5;
        let restrictions = vec![vec![2, 1], vec![4, 1]];
        let result = Solution::max_building(n, restrictions);

        assert_eq!(result, 2)
    }
    #[test]
    fn case2() {
        let n = 6;
        let restrictions = vec![];
        let result = Solution::max_building(n, restrictions);

        assert_eq!(result, 5)
    }
    #[test]
    fn case3() {
        let n = 10;
        let restrictions = vec![vec![5, 3], vec![2, 5], vec![7, 4], vec![10, 3]];
        let result = Solution::max_building(n, restrictions);

        assert_eq!(result, 5)
    }
}

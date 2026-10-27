mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let m = 2;
        let n = 3;
        let result = Solution::create_grid(m, n);

        assert_eq!(result, result);
    }
    #[test]
    fn case2() {
        let m = 3;
        let n = 3;
        let result = Solution::create_grid(m, n);

        assert_eq!(result, result);
    }
    #[test]
    fn case3() {
        let m = 1;
        let n = 4;
        let result = Solution::create_grid(m, n);

        assert_eq!(result, result);
    }
}

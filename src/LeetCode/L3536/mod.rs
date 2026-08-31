mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 31;
        let result = Solution::max_product(n);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let n = 22;
        let result = Solution::max_product(n);

        assert_eq!(result, 4);
    }
    #[test]
    fn case3() {
        let n = 124;
        let result = Solution::max_product(n);

        assert_eq!(result, 8);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 8;
        let result = Solution::pivot_integer(n);

        assert_eq!(result, 6);
    }
    #[test]
    fn case2() {
        let n = 1;
        let result = Solution::pivot_integer(n);

        assert_eq!(result, 1);
    }
    #[test]
    fn case3() {
        let n = 4;
        let result = Solution::pivot_integer(n);

        assert_eq!(result, -1);
    }
}

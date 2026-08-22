mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 99;
        let result = Solution::check_divisibility(n);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let n = 23;
        let result = Solution::check_divisibility(n);

        assert_eq!(result, false);
    }
}

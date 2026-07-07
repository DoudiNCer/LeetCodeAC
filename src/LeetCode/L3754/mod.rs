mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 10203004;
        let result = Solution::sum_and_multiply(n);

        assert_eq!(result, 12340);
    }
    #[test]
    fn case2() {
        let n = 1000;
        let result = Solution::sum_and_multiply(n);

        assert_eq!(result, 1);
    }
}

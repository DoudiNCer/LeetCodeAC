mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let num = 38;
        let result = Solution::add_digits(num);
        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let num = 0;
        let result = Solution::add_digits(num);
        assert_eq!(result, 0);
    }
}

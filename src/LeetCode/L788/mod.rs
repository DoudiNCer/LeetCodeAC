mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let n = 10;
        let result = Solution::rotated_digits(n);

        assert_eq!(result, 4)
    }
    #[test]
    fn case2() {
        let n = 2;
        let result = Solution::rotated_digits(n);

        assert_eq!(result, 1)
    }
}

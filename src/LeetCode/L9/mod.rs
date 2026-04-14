mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let x = 121;
        let result = Solution::is_palindrome(x);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let x = -121;
        let result = Solution::is_palindrome(x);

        assert_eq!(result, false);
    }
    #[test]
    fn case3() {
        let x = 10;
        let result = Solution::is_palindrome(x);

        assert_eq!(result, false);
    }
}

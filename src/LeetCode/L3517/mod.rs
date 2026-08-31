mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("z");
        let result = Solution::smallest_palindrome(s);
        let target = String::from("z");

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let s = String::from("babab");
        let result = Solution::smallest_palindrome(s);
        let target = String::from("abbba");

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let s = String::from("daccad");
        let result = Solution::smallest_palindrome(s);
        let target = String::from("acddca");

        assert_eq!(result, target);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("()");
        let result = Solution::is_valid(s);

        assert_eq!(result, true);
    }
    #[test]
    fn case2() {
        let s = String::from("()[]{}");
        let result = Solution::is_valid(s);

        assert_eq!(result, true);
    }
    #[test]
    fn case3() {
        let s = String::from("(]");
        let result = Solution::is_valid(s);

        assert_eq!(result, false);
    }
    #[test]
    fn case4() {
        let s = String::from("([])");
        let result = Solution::is_valid(s);

        assert_eq!(result, true);
    }
    #[test]
    fn case5() {
        let s = String::from("([)]");
        let result = Solution::is_valid(s);

        assert_eq!(result, false);
    }
}

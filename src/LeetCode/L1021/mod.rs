mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("(()())(())");
        let result = Solution::remove_outer_parentheses(s);
        let target = String::from("()()()");

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let s = String::from("(()())(())(()(()))");
        let result = Solution::remove_outer_parentheses(s);
        let target = String::from("()()()()(())");

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let s = String::from("()()");
        let result = Solution::remove_outer_parentheses(s);
        let target = String::from("");

        assert_eq!(result, target);
    }
}

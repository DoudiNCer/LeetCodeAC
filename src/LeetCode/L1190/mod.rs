mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("(abcd)");
        let result = Solution::reverse_parentheses(s);
        let target = String::from("dcba");

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let s = String::from("(u(love)i)");
        let result = Solution::reverse_parentheses(s);
        let target = String::from("iloveu");

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let s = String::from("(ed(et(oc))el)");
        let result = Solution::reverse_parentheses(s);
        let target = String::from("leetcode");

        assert_eq!(result, target);
    }
}

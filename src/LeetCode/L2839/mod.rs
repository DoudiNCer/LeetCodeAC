mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s1 = String::from("abcd");
        let s2 = String::from("cdab");
        let result = Solution::can_be_equal(s1, s2);
        assert!(result)
    }
    #[test]
    fn case2() {
        let s1 = String::from("abcd");
        let s2 = String::from("dacb");
        let result = Solution::can_be_equal(s1, s2);
        assert!(!result)
    }
}

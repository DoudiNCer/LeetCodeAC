mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s1 = String::from("abcdba");
        let s2 = String::from("cabdab");
        let result = Solution::check_strings(s1, s2);
        assert!(result)
    }
    #[test]
    fn case2() {
        let s1 = String::from("abe");
        let s2 = String::from("bea");
        let result = Solution::check_strings(s1, s2);
        assert!(!result)
    }
}
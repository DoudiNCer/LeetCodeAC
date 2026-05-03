mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("abcde");
        let goal = String::from("cdeab");
        let result = Solution::rotate_string(s, goal);

        assert_eq!(result, true)
    }
    #[test]
    fn case2() {
        let s = String::from("abcde");
        let goal = String::from("abced");
        let result = Solution::rotate_string(s, goal);

        assert_eq!(result, false)
    }
}

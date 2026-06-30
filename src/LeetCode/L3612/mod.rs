mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("a#b%*");
        let result = Solution::process_str(s);

        assert_eq!(result, String::from("ba"));
    }
    #[test]
    fn case2() {
        let s = String::from("z*#");
        let result = Solution::process_str(s);

        assert_eq!(result, String::from(""));
    }
}

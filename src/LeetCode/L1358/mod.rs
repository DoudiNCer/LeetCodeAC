mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("abcabc");
        let result = Solution::number_of_substrings(s);

        assert_eq!(result, 10);
    }
    #[test]
    fn case2() {
        let s = String::from("aaacb");
        let result = Solution::number_of_substrings(s);

        assert_eq!(result, 3);
    }
    #[test]
    fn case3() {
        let s = String::from("abc");
        let result = Solution::number_of_substrings(s);

        assert_eq!(result, 1);
    }
}

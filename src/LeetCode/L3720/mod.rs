mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("abc");
        let target = String::from("bba");
        let result = Solution::lex_greater_permutation(s, target);

        assert_eq!(result, String::from("bca"));
    }
    #[test]
    fn case2() {
        let s = String::from("leet");
        let target = String::from("code");
        let result = Solution::lex_greater_permutation(s, target);

        assert_eq!(result, String::from("eelt"));
    }
    #[test]
    fn case3() {
        let s = String::from("baba");
        let target = String::from("bbaa");
        let result = Solution::lex_greater_permutation(s, target);

        assert_eq!(result, String::from(""));
    }
    #[test]
    fn case4() {
        let s = String::from("ab");
        let target = String::from("ab");
        let result = Solution::lex_greater_permutation(s, target);

        assert_eq!(result, String::from("ba"));
    }
}

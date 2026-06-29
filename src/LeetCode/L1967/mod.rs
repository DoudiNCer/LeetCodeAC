mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let patterns = vec![
            String::from("a"),
            String::from("abc"),
            String::from("bc"),
            String::from("d"),
        ];
        let word = String::from("abc");
        let result = Solution::num_of_strings(patterns, word);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let patterns = vec![String::from("a"), String::from("b"), String::from("v")];
        let word = String::from("aaaaabbbbb");
        let result = Solution::num_of_strings(patterns, word);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let patterns = vec![String::from("a"), String::from("a"), String::from("a")];
        let word = String::from("ab");
        let result = Solution::num_of_strings(patterns, word);

        assert_eq!(result, 3);
    }
}

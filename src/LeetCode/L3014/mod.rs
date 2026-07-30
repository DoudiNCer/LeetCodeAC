mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let word = String::from("abcde");
        let result = Solution::minimum_pushes(word);

        assert_eq!(result, 5);
    }
    #[test]
    fn case2() {
        let word = String::from("xycdefghij");
        let result = Solution::minimum_pushes(word);

        assert_eq!(result, 12);
    }
}

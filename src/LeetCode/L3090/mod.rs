mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = "bcbbbcba".to_string();
        let result = Solution::maximum_length_substring(s);

        assert_eq!(result, 4);
    }
    #[test]
    fn case2() {
        let s = "aaaa".to_string();
        let result = Solution::maximum_length_substring(s);

        assert_eq!(result, 2);
    }
}

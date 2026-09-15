mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = "abaccdbbd".to_string();
        let k = 3;
        let result = Solution::max_palindromes(s, k);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let s = "adbcda".to_string();
        let k = 2;
        let result = Solution::max_palindromes(s, k);

        assert_eq!(result, 0);
    }
}

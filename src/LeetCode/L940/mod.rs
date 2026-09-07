mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = "abc".to_string();
        let result = Solution::distinct_subseq_ii(s);

        assert_eq!(result, 7)
    }
    #[test]
    fn case2() {
        let s = "aba".to_string();
        let result = Solution::distinct_subseq_ii(s);

        assert_eq!(result, 6)
    }
    #[test]
    fn case3() {
        let s = "aaa".to_string();
        let result = Solution::distinct_subseq_ii(s);

        assert_eq!(result, 3)
    }
}

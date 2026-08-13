mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = "babacc".to_string();
        let queryCharacters = "bcb".to_string();
        let queryIndices = vec![1, 3, 3];
        let result = Solution::longest_repeating(s, queryCharacters, queryIndices);
        let target = vec![3, 3, 4];

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let s = "abyzz".to_string();
        let queryCharacters = "aa".to_string();
        let queryIndices = vec![2, 1];
        let result = Solution::longest_repeating(s, queryCharacters, queryIndices);
        let target = vec![2, 3];

        assert_eq!(result, target)
    }
}

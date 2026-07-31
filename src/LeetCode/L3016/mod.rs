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
        let word = String::from("xyzxyzxyzxyz");
        let result = Solution::minimum_pushes(word);

        assert_eq!(result, 12);
    }
    #[test]
    fn case3() {
        let word = String::from("aabbccddeeffgghhiiiiii");
        let result = Solution::minimum_pushes(word);

        assert_eq!(result, 24);
    }
}

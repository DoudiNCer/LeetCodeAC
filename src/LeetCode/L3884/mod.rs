mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("abcacbd");
        let result = Solution::first_matching_index(s);

        assert_eq!(result, 1);
    }
    #[test]
    fn case2() {
        let s = String::from("abc");
        let result = Solution::first_matching_index(s);

        assert_eq!(result, 1);
    }
}

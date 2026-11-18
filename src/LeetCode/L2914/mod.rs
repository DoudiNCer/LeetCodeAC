mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("1001");
        let result = Solution::min_changes(s);

        assert_eq!(result, 2)
    }
    #[test]
    fn case2() {
        let s = String::from("10");
        let result = Solution::min_changes(s);

        assert_eq!(result, 1)
    }
    #[test]
    fn case3() {
        let s = String::from("0000");
        let result = Solution::min_changes(s);

        assert_eq!(result, 0)
    }
}

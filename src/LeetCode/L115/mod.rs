mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = "rabbbit".to_string();
        let t = "rabbit".to_string();
        let result = Solution::num_distinct(s, t);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let s = "babgbag".to_string();
        let t = "bag".to_string();
        let result = Solution::num_distinct(s, t);

        assert_eq!(result, 5);
    }
}

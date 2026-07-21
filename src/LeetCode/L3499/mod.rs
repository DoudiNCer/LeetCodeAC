mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = String::from("01");
        let result = Solution::max_active_sections_after_trade(s);

        assert_eq!(result, 1);
    }
    #[test]
    fn case2() {
        let s = String::from("0100");
        let result = Solution::max_active_sections_after_trade(s);

        assert_eq!(result, 4);
    }
    #[test]
    fn case3() {
        let s = String::from("1000100");
        let result = Solution::max_active_sections_after_trade(s);

        assert_eq!(result, 7);
    }
    #[test]
    fn case4() {
        let s = String::from("01010");
        let result = Solution::max_active_sections_after_trade(s);

        assert_eq!(result, 4);
    }
}

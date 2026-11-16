mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let s = "11111222223".to_string();
        let k = 3;
        let result = Solution::digit_sum(s, k);
        let target = "135".to_string();

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let s = "00000000".to_string();
        let k = 3;
        let result = Solution::digit_sum(s, k);
        let target = "000".to_string();

        assert_eq!(result, target)
    }
    #[test]
    fn case3() {
        let s = "71818186138735364590516322993378229838446988388364431324753408563431136824898916288399".to_string();
        let k = 85;
        let result = Solution::digit_sum(s, k);
        let target = "4169".to_string();

        assert_eq!(result, target)
    }
}

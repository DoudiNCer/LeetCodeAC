mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let str = String::from("aaAbcBC");
        let result = Solution::number_of_special_chars(str);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let str = String::from("abc");
        let result = Solution::number_of_special_chars(str);

        assert_eq!(result, 0);
    }
    #[test]
    fn case3() {
        let str = String::from("abBCab");
        let result = Solution::number_of_special_chars(str);

        assert_eq!(result, 1);
    }
}

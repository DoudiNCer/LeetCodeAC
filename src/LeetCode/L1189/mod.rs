mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let text = String::from("nlaebolko");
        let result = Solution::max_number_of_balloons(text);

        assert_eq!(result, 1);
    }
    #[test]
    fn case2() {
        let text = String::from("loonbalxballpoon");
        let result = Solution::max_number_of_balloons(text);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let text = String::from("leetcode");
        let result = Solution::max_number_of_balloons(text);

        assert_eq!(result, 0);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let num = 2;
        let sum = 3;
        let result = Solution::max_sum_of_squares(num, sum);

        assert_eq!(result, String::from("30"));
    }
    #[test]
    fn case2() {
        let num = 2;
        let sum = 17;
        let result = Solution::max_sum_of_squares(num, sum);

        assert_eq!(result, String::from("98"));
    }
    #[test]
    fn case3() {
        let num = 1;
        let sum = 10;
        let result = Solution::max_sum_of_squares(num, sum);

        assert_eq!(result, String::from(""));
    }
}

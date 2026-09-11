mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let digits = vec![1, 2, 3, 4];
        let result = Solution::total_numbers(digits);

        assert_eq!(result, 12);
    }
    #[test]
    fn case2() {
        let digits = vec![0, 2, 2];
        let result = Solution::total_numbers(digits);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let digits = vec![6, 6, 6];
        let result = Solution::total_numbers(digits);

        assert_eq!(result, 1);
    }
    #[test]
    fn case4() {
        let digits = vec![1, 3, 5];
        let result = Solution::total_numbers(digits);

        assert_eq!(result, 0);
    }
}

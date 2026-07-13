mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let low = 100;
        let high = 300;
        let result = Solution::sequential_digits(low, high);
        let mut target = vec![123, 234];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let low = 1000;
        let high = 13000;
        let result = Solution::sequential_digits(low, high);
        let mut target = vec![1234, 2345, 3456, 4567, 5678, 6789, 12345];

        assert_eq!(result, target);
    }
}

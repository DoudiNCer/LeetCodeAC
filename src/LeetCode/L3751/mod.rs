mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let num1 = 120;
        let num2 = 130;
        let result = Solution::total_waviness(num1, num2);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let num1 = 198;
        let num2 = 202;
        let result = Solution::total_waviness(num1, num2);

        assert_eq!(result, 3);
    }
}

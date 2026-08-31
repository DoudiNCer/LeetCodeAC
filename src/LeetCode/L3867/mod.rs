mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![2, 6, 4];
        let result = Solution::gcd_sum(nums);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let nums = vec![3, 6, 2, 8];
        let result = Solution::gcd_sum(nums);

        assert_eq!(result, 5);
    }
}

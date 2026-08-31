mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1,2,3];
        let result = Solution::maximum_product(nums);

        assert_eq!(result, 6);
    }
    #[test]
    fn case2() {
        let nums = vec![1,2,3,4];
        let result = Solution::maximum_product(nums);

        assert_eq!(result, 24);
    }
    #[test]
    fn case3() {
        let nums = vec![-1,-2,-3];
        let result = Solution::maximum_product(nums);

        assert_eq!(result, -6);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![3, 4, 5, 2];
        let result = Solution::max_product(nums);

        assert_eq!(result, 12);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 5, 4, 5];
        let result = Solution::max_product(nums);

        assert_eq!(result, 16);
    }
    #[test]
    fn case3() {
        let nums = vec![3, 7];
        let result = Solution::max_product(nums);

        assert_eq!(result, 12);
    }
}

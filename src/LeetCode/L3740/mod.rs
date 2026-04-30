mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 1, 1, 3];
        let result = Solution::minimum_distance(nums);
        assert_eq!(result, 6)
    }
    #[test]
    fn case2() {
        let nums = vec![1, 1, 2, 3, 2, 1, 2];
        let result = Solution::minimum_distance(nums);
        assert_eq!(result, 8)
    }
    #[test]
    fn case3() {
        let nums = vec![1];
        let result = Solution::minimum_distance(nums);
        assert_eq!(result, -1)
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![3, 4, 5, 1, 2];
        let result = Solution::find_min(nums);

        assert_eq!(result, 1);
    }
    #[test]
    fn case2() {
        let nums = vec![4, 5, 6, 7, 0, 1, 2];
        let result = Solution::find_min(nums);

        assert_eq!(result, 0);
    }
    #[test]
    fn case3() {
        let nums = vec![11, 13, 15, 17];
        let result = Solution::find_min(nums);

        assert_eq!(result, 11);
    }
    #[test]
    fn case4() {
        let nums = vec![3, 1, 2];
        let result = Solution::find_min(nums);

        assert_eq!(result, 1);
    }
}

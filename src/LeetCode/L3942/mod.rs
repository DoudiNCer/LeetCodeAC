mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![0, 2, 1];
        let result = Solution::min_operations(nums);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 0, 2];
        let result = Solution::min_operations(nums);

        assert_eq!(result, 2);
    }
    #[test]
    fn case3() {
        let nums = vec![2, 0, 1, 3];
        let result = Solution::min_operations(nums);

        assert_eq!(result, -1);
    }
    #[test]
    fn case4() {
        let nums = vec![0, 1, 2, 3];
        let result = Solution::min_operations(nums);

        assert_eq!(result, 0);
    }
    #[test]
    fn case5() {
        let nums = vec![3, 2, 1, 0];
        let result = Solution::min_operations(nums);

        assert_eq!(result, 1);
    }
    #[test]
    fn case6() {
        let nums = vec![1, 0];
        let result = Solution::min_operations(nums);

        assert_eq!(result, 1);
    }
    #[test]
    fn case7() {
        let nums = vec![0,1];
        let result = Solution::min_operations(nums);

        assert_eq!(result, 0);
    }
}

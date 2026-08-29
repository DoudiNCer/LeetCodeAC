mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 5, 3, 9, 8];
        let limit = 2;
        let result = Solution::lexicographically_smallest_array(nums, limit);
        let target = vec![1, 3, 5, 8, 9];

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let nums = vec![1, 7, 6, 18, 2, 1];
        let limit = 3;
        let result = Solution::lexicographically_smallest_array(nums, limit);
        let target = vec![1, 6, 7, 18, 1, 2];

        assert_eq!(result, target)
    }
    #[test]
    fn case3() {
        let nums = vec![1, 7, 28, 19, 10];
        let limit = 3;
        let result = Solution::lexicographically_smallest_array(nums, limit);
        let target = vec![1, 7, 28, 19, 10];

        assert_eq!(result, target)
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 2, 3];
        let target = 2;
        let result = Solution::count_majority_subarrays(nums, target);

        assert_eq!(result, 5)
    }
    #[test]
    fn case2() {
        let nums = vec![1, 1, 1, 1];
        let target = 1;
        let result = Solution::count_majority_subarrays(nums, target);

        assert_eq!(result, 10)
    }
    #[test]
    fn case3() {
        let nums = vec![1, 2, 3];
        let target = 4;
        let result = Solution::count_majority_subarrays(nums, target);

        assert_eq!(result, 0)
    }
}

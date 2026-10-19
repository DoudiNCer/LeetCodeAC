mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 5, 2, 3];
        let target = 2;
        let result = Solution::target_indices(nums, target);

        assert_eq!(result, vec![1, 2])
    }
    #[test]
    fn case2() {
        let nums = vec![1, 2, 5, 2, 3];
        let target = 3;
        let result = Solution::target_indices(nums, target);

        assert_eq!(result, vec![3])
    }
    #[test]
    fn case3() {
        let nums = vec![1, 2, 5, 2, 3];
        let target = 5;
        let result = Solution::target_indices(nums, target);

        assert_eq!(result, vec![4])
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 1, 4, 2, 3];
        let x = 5;
        let result = Solution::min_operations(nums, x);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let nums = vec![5, 6, 7, 8, 9];
        let x = 4;
        let result = Solution::min_operations(nums, x);

        assert_eq!(result, -1);
    }
    #[test]
    fn case3() {
        let nums = vec![3, 2, 20, 1, 1, 3];
        let x = 10;
        let result = Solution::min_operations(nums, x);

        assert_eq!(result, 5);
    }
}

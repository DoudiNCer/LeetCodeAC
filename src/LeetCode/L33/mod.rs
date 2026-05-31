mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![4, 5, 6, 7, 0, 1, 2];
        let target = 0;
        let result = Solution::search(nums, target);

        assert_eq!(result, 4);
    }
    #[test]
    fn case2() {
        let nums = vec![4, 5, 6, 7, 0, 1, 2];
        let target = 3;
        let result = Solution::search(nums, target);

        assert_eq!(result, -1);
    }
    #[test]
    fn case3() {
        let nums = vec![1];
        let target = 0;
        let result = Solution::search(nums, target);

        assert_eq!(result, -1);
    }
}

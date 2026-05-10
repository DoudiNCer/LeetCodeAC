mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 3, 6, 4, 1, 2];
        let target = 2;
        let result = Solution::maximum_jumps(nums, target);

        assert_eq!(result, 3);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 3, 6, 4, 1, 2];
        let target = 3;
        let result = Solution::maximum_jumps(nums, target);

        assert_eq!(result, 5);
    }
    #[test]
    fn case3() {
        let nums = vec![1, 3, 6, 4, 1, 2];
        let target = 0;
        let result = Solution::maximum_jumps(nums, target);

        assert_eq!(result, -1);
    }
}

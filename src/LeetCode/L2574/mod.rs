mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![10, 4, 8, 3];
        let result = Solution::left_right_difference(nums);
        let target = vec![15, 1, 11, 22];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let nums = vec![1];
        let result = Solution::left_right_difference(nums);
        let target = vec![0];

        assert_eq!(result, target);
    }
}

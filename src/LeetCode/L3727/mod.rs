mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3];
        let result = Solution::max_alternating_sum(nums);

        assert_eq!(result, 12);
    }
    #[test]
    fn case2() {
        let nums = vec![1, -1, 2, -2, 3, -3];
        let result = Solution::max_alternating_sum(nums);

        assert_eq!(result, 16);
    }
}

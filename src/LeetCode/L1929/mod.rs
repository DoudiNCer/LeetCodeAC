mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 1];
        let result = Solution::get_concatenation(nums);
        assert_eq!(result, vec![1, 2, 1, 1, 2, 1]);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 3, 2, 1];
        let result = Solution::get_concatenation(nums);
        assert_eq!(result, vec![1, 3, 2, 1, 1, 3, 2, 1]);
    }
}

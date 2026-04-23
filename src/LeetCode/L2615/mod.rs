mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 3, 1, 1, 2];
        let result = Solution::distance(nums);

        assert_eq!(result, vec![5, 0, 3, 4, 0]);
    }
    #[test]
    fn case2() {
        let nums = vec![0, 5, 3];
        let result = Solution::distance(nums);

        assert_eq!(result, vec![0, 0, 0]);
    }
}

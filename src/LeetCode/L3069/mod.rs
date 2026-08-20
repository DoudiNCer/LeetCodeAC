mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![2, 1, 3];
        let result = Solution::result_array(nums);
        let target = vec![2, 3, 1];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let nums = vec![5, 4, 3, 8];
        let result = Solution::result_array(nums);
        let target = vec![5, 3, 4, 8];

        assert_eq!(result, target);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 4, 2, 5];
        let result = Solution::find_missing_elements(nums);
        let target = vec![3];

        assert_eq!(result, target)
    }
    #[test]
    fn case2() {
        let nums = vec![7, 8, 6, 9];
        let result = Solution::find_missing_elements(nums);
        let target = vec![];

        assert_eq!(result, target)
    }
    #[test]
    fn case3() {
        let nums = vec![5, 1];
        let result = Solution::find_missing_elements(nums);
        let target = vec![2, 3, 4];

        assert_eq!(result, target)
    }
}

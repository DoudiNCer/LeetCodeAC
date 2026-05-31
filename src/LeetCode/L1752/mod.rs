mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![3, 4, 5, 1, 2];
        let result = Solution::check(nums);

        assert_eq!(result, true)
    }
    #[test]
    fn case2() {
        let nums = vec![2, 1, 3, 4];
        let result = Solution::check(nums);

        assert_eq!(result, false)
    }
}

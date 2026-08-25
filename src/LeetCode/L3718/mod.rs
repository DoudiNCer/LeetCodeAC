mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![8, 2, 3, 4, 6];
        let mut k = 2;
        let result = Solution::missing_multiple(nums, k);

        assert_eq!(result, 10)
    }
    #[test]
    fn case2() {
        let nums = vec![1, 4, 7, 10, 15];
        let mut k = 5;
        let result = Solution::missing_multiple(nums, k);

        assert_eq!(result, 5)
    }
    #[test]
    fn case3() {
        let nums = vec![99];
        let mut k = 99;
        let result = Solution::missing_multiple(nums, k);

        assert_eq!(result, 198)
    }
}

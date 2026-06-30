mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 3, 2];
        let k = 2;
        let result = Solution::max_total_value(nums, k);

        assert_eq!(result, 4);
    }
    #[test]
    fn case2() {
        let nums = vec![4, 2, 5, 1];
        let k = 3;
        let result = Solution::max_total_value(nums, k);

        assert_eq!(result, 12);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 2, 3, 4, 5];
        let k = 3;
        let result = Solution::result_array(nums, k);
        let target = vec![9, 2, 4];

        assert_eq!(result, target);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 2, 4, 8, 16, 32];
        let k = 4;
        let result = Solution::result_array(nums, k);
        let target = vec![18, 1, 2, 0];

        assert_eq!(result, target);
    }
    #[test]
    fn case3() {
        let nums = vec![1, 1, 2, 1, 1];
        let k = 2;
        let result = Solution::result_array(nums, k);
        let target = vec![9, 6];

        assert_eq!(result, target);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![2, 5, 1, 3, 4, 7];
        let n = 3;
        let result = Solution::shuffle(nums, n);
        assert_eq!(result, vec![2, 3, 5, 4, 1, 7]);
    }
    #[test]
    fn case2() {
        let nums = vec![1, 2, 3, 4, 4, 3, 2, 1];
        let n = 4;
        let result = Solution::shuffle(nums, n);
        assert_eq!(result, vec![1, 4, 2, 3, 3, 2, 4, 1]);
    }
    #[test]
    fn case3() {
        let nums = vec![1, 1, 2, 2];
        let n = 2;
        let result = Solution::shuffle(nums, n);
        assert_eq!(result, vec![1, 2, 1, 2]);
    }
}

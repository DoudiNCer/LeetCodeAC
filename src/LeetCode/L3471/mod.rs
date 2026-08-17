mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![3, 9, 2, 1, 7];
        let k = 3;
        let result = Solution::largest_integer(nums, k);

        assert_eq!(result, 7);
    }
    #[test]
    fn case2() {
        let nums = vec![3, 9, 7, 2, 1, 7];
        let k = 4;
        let result = Solution::largest_integer(nums, k);

        assert_eq!(result, 3);
    }
    #[test]
    fn case3() {
        let nums = vec![0, 0];
        let k = 1;
        let result = Solution::largest_integer(nums, k);

        assert_eq!(result, -1);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 3];
        let result = Solution::unique_xor_triplets(nums);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let nums = vec![6, 7, 8, 9];
        let result = Solution::unique_xor_triplets(nums);

        assert_eq!(result, 4);
    }
    #[test]
    fn case3() {
        let nums = vec![3, 1, 2, 4];
        let result = Solution::unique_xor_triplets(nums);

        assert_eq!(result, 8);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![1, 3, 2];
        let result = Solution::smallest_index(nums);

        assert_eq!(result, 2);
    }
    #[test]
    fn case2() {
        let nums = vec![1,10,11];
        let result = Solution::smallest_index(nums);

        assert_eq!(result, 1);
    }
    #[test]
    fn case3() {
        let nums = vec![1,2,3];
        let result = Solution::smallest_index(nums);

        assert_eq!(result, -1);
    }
}

mod solution;
struct Solution;
#[cfg(test)]
mod tests {
    use super::*;
    #[test]
    fn case1() {
        let nums = vec![4, 3, 2, 6];
        let result = Solution::max_rotate_function(nums);

        assert_eq!(result, 26);
    }
    #[test]
    fn case2() {
        let nums = vec![100];
        let result = Solution::max_rotate_function(nums);

        assert_eq!(result, 0);
    }
}
